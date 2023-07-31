package com.yuri.mypet.service;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yuri.mypet.domain.EventProvider;
import com.yuri.mypet.domain.LoginConjunto;
import com.yuri.mypet.domain.PetClient;
import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;
import com.yuri.mypet.dto.PetClientDTO;
import com.yuri.mypet.dto.PetClientNewDTO;
import com.yuri.mypet.repositories.EnderecoFisicoRepository;
import com.yuri.mypet.repositories.LoginConjuntoRepository;
import com.yuri.mypet.repositories.PetClientRepository;
import com.yuri.mypet.security.UserSS;
import com.yuri.mypet.service.exceptions.AuthorizationException;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;

@Service
public class PetClientService {

	@Autowired
	PetClientRepository petClientRepository;
	@Autowired
	EnderecoFisicoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoderEncoder;
	
	@Autowired
	private S3Service s3Service;

	@Autowired
	private LoginConjuntoRepository loginConjuntoRepository;

	@Autowired
	private ImageService imageService;

	@Value("${img.prefix.client.profile}")
	private String prefix;

	@Value("${img.profile.size}")
	private Integer size;
 

	public PetClient find(Integer id) {

		/*
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado ");
		}
		*/
		
		Optional<PetClient> op = petClientRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetClient.class.getName()));
	}

	public PetClient findEmail(String email){

		PetClient petC = petClientRepository.findByEmail(email);
		return petC;
	}

	@Transactional /**
					 * para que tudo ocorra de forma trasicional (salava endereço e cliente em uma
					 * tra)
					 */
	public PetClient insert(PetClient obj) {
		obj.setId(null);
		obj = petClientRepository.save(obj); /**
												 * salva cliente enderecoRepository.saveAll(obj.getEndereço()); // salva
												 * endereço
												 */
		return obj;
	}

	public PetClient update(PetClient obj) {
		PetClient newObj = find(obj.getId()); // instanciar um cliente a parir do banco dados
		updateData(newObj, obj); // atulaiza os dados como o obj que foi enviado na requisição
		return petClientRepository.save(newObj); /**
													 * save vale quanto para inserir quanto para update unica coisa que
													 * ele olha é se o Id esta nulo ele insere se não atualiza
													 */
	}

	public void delete(Integer id) {
		find(id);
		try {
			petClientRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há pedidos relacionadas");
		}
	}

	public List<PetClient> findAll() {
		return petClientRepository.findAll();
	}
	
	public Page<PetClient> findPage(Integer page, Integer linesPerPage, String orderBy,
			String direction) {/**
								 * Page vai encapsular informações e operações sobre a paginação
								 */

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy); /**
							 * prepara as informações para que faça a consulta que retorne a pagina de dados
							 */
		return petClientRepository.findAll(pageRequest); // Direction convertendo do tipo String para o tipo Direction
	}

	public PetClient fromDto(PetClientDTO objDto) { /**
													 * metado auxiliar que instacia uma categoria a partir de um DTO
													 */

		return new PetClient(objDto.getId(),null, objDto.getNomeCompleto(), objDto.getEmail(), objDto.getCpf(),
				null, null, bCryptPasswordEncoderEncoder.encode(objDto.getSenha()), null, objDto.getDescricao(), objDto.getDataNascimento(), objDto.getLogradouro(), objDto.getNumero(), 
				objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getEstado(), objDto.getActive(), objDto.getTelefoneFixo(), 
				objDto.getTelefoneCelular());

	}

	public PetClient fromDto(PetClientNewDTO objDto) {

		PetClient cli1 = new PetClient(null, objDto.getUsername(), objDto.getNomeCompleto(), objDto.getEmail(),
				objDto.getCpf(), TipoCliente.toEnum(objDto.getTipoPerfil()), Perfil.CLIENTE,
				bCryptPasswordEncoderEncoder.encode(objDto.getSenha()), null, objDto.getDescricao(),
				objDto.getDataNascimento(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getEstado(), objDto.getActive(), objDto.getTelefoneFixo(), 
				objDto.getTelefoneCelular());

			//	PetClient w = new PetClient(id, username, nomeCompleto, email, cpf, tipoPerfil, perfil, senha, fotoPerfil, descricao, dataNascimento, logradouro, numero, complemento, bairro, cep, cidade, estado, active, telefoneFixo, telefoneCelular)

		return cli1;
	}

	private void updateData(PetClient newObj, PetClient obj) { /**
																 * metado aux para atualizar os campos do cliente,
																 * pegando o novo e colocando no antigo
																 */
		newObj.setEmail(obj.getEmail());
		newObj.setActive(obj.getActive());
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		newObj.setCidade(obj.getCidade());
		newObj.setComplemento(obj.getComplemento());
		newObj.setCpf(obj.getCpf());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setEstado(obj.getEstado());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNomeCompleto(obj.getNomeCompleto());
		newObj.setNumero(obj.getNumero());
		newObj.setSenha(obj.getSenha());
		newObj.setTelefoneFixo(obj.getTelefoneFixo());
		newObj.setTelefoneCelular(obj.getTelefoneCelular());
	}

	public URI uploadPicture(MultipartFile multipartFile) {
		
		UserSS user = UserService.authenticated(); // verifica se esta logado

		if(user == null){
			throw new AuthorizationException("Acesso negado");
		}
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		String fileName = prefix + user.getId() + ".jpg";
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);


		URI uri =  s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image"); // endereco da imagem


		
		PetClient pet = find(user.getId());
		pet.setFotoPerfil(uri.toString());
		petClientRepository.save(pet);

		return uri;

	}
}
