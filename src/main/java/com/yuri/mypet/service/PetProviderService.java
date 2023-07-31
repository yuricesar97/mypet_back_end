package com.yuri.mypet.service;

import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;
import com.yuri.mypet.dto.PetProviderDTO;
import com.yuri.mypet.dto.PetProviderNewDTO;
import com.yuri.mypet.repositories.EnderecoJuridicoRepository;
import com.yuri.mypet.repositories.PetProviderRepository;
import com.yuri.mypet.security.UserSS;
import com.yuri.mypet.service.exceptions.AuthorizationException;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PetProviderService {

	@Autowired
	PetProviderRepository petProviderRepository;
	@Autowired
	EnderecoJuridicoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ImageService imageService;

	@Value("${img.prefix.servico.profile}")
	private String prefix;
 

	public PetProvider find(Integer id) {
		/*
		UserSS user = UserService.authenticated();

		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negedo");
		}
		*/
		Optional<PetProvider> op = petProviderRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetProvider.class.getName()));
	}


	public List<PetProvider> findByCidadeAndEstado(String cidade, String estado) {
		List<PetProvider> op = petProviderRepository.findByCidadeAndEstado(cidade, estado);
		
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! cidade ou estado: " +cidade + ", tipo: " + PetProvider.class.getName());
		}
	return op;
	}

	public List<PetProvider> findByCidadeAndEstadoAndBairros(String cidade, String razaoSocial, String bairro) {
		List<PetProvider> op = petProviderRepository.findByCidadeAndEstadoAndBairro(cidade, razaoSocial,bairro);
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! cidade ,estado bairro: " +cidade + ", tipo: " + PetProvider.class.getName());
		}
	return op;
	}


	public List<PetProvider> findByCidadeAndRazaoSocial(String cidade, String razaoSocial) {
		List<PetProvider> op = petProviderRepository.findByCidadeAndRazaoSocial(cidade, razaoSocial);
		if(op == null){
			throw new ObjectNotFoundException(
					"Objeto não encontrado! cidade ,estado bairro: " +cidade + ", tipo: " + PetProvider.class.getName());
		}
		return op;
	}
	

	@Transactional
	public PetProvider insert(PetProvider obj) {
		obj.setId(null);
		obj = petProviderRepository.save(obj);
		return obj;
	}

	public PetProvider update(PetProvider obj) {
		PetProvider newObj = find(obj.getId());
		updateData(newObj, obj);
		return petProviderRepository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			petProviderRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há pedidos relacionadas");
		}
	}

	public List<PetProvider> findAll() {
		return petProviderRepository.findAll();
	}

	public Page<PetProvider> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return petProviderRepository.findAll(pageRequest);
	}

	

	public PetProvider fromDto(PetProviderDTO objDto) {

		return new PetProvider(objDto.getId(), objDto.getRazaoSocial(), objDto.getEmail(), objDto.getCpf(), null, null,
		null, null, objDto.getSituacaoAprovacao(), objDto.getBanhoETosa(), objDto.getVacinacao(),	objDto.getConsulta(), objDto.getExames(), objDto.getCirurgiaGeral(), objDto.getHidratacao(), objDto.getPenteadosArtisticos(), objDto.getTosaExotica(), objDto.getAcupuntura(), objDto.getSpa(), objDto.getHotel(), objDto.getCreche(), objDto.getTaxi(), objDto.getEnsaioFotografico(), objDto.getAdestramento(), objDto.getMassagem(), objDto.getPetwalk(), objDto.isCheckStatus(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getEstado(), objDto.getActive(), objDto.getTelefoneFixo(), objDto.getTelefoneCelular());
	}

	public PetProvider fromDto(PetProviderNewDTO objDto) {

		PetProvider cli1 = new PetProvider(null, objDto.getRazaoSocial(), objDto.getEmail(), objDto.getCpf(), TipoCliente.toEnum(objDto.getTipoPerfil()), Perfil.SERVICO, bCryptPasswordEncoder.encode(objDto.getSenha()),
		null, objDto.getSituacaoAprovacao(), objDto.getBanhoETosa(), objDto.getVacinacao(),	objDto.getConsulta(), objDto.getExames(), objDto.getCirurgiaGeral(), objDto.getHidratacao(), 
		objDto.getPenteadosArtisticos(), objDto.getTosaExotica(), objDto.getAcupuntura(), objDto.getSpa(), objDto.getHotel(), objDto.getCreche(), objDto.getTaxi(), objDto.getEnsaioFotografico(), objDto.getAdestramento(), objDto.getMassagem(), objDto.getPetwalk(), objDto.isCheckStatus(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getEstado(), objDto.getActive(), objDto.getTelefoneFixo(), objDto.getTelefoneCelular());


		//PetProvider cli1 = new PetProvider(id, razaoSocial, email, cpf, tipoPerfil, perfil, senha, fotoPerfil, situacaoAprovacao, banhoETosa, vacinacao, consulta, exames, cirurgiaGeral, hidratacao, penteadosArtisticos, tosaExotica, acupuntura, spa, hotel, creche, taxi, ensaioFotografico, adestramento, massagem, petwalk, checkStatus, logradouro, numero, complemento, bairro, cep, cidade, estado, active, telefoneFixo, telefoneCelular)

		return cli1;
	}

	private void updateData(PetProvider newObj, PetProvider obj) {

		//dados do fornecedor
		newObj.setRazaoSocial(obj.getRazaoSocial());
		newObj.setCpf(obj.getCpf());
		newObj.setId(obj.getId());
		newObj.setCheckStatus(obj.isCheckStatus());
		newObj.setFotoPerfil(obj.getFotoPerfil());
		//dados de acesso
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setSituacaoAprovacao(obj.getSituacaoAprovacao());
		newObj.setActive(obj.getActive());
		//dados de endereco
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		newObj.setCidade(obj.getCidade());
		newObj.setComplemento(obj.getComplemento());
		newObj.setEstado(obj.getEstado());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		//telefones
		newObj.setTelefoneFixo(obj.getTelefoneFixo());
		newObj.setTelefoneCelular(obj.getTelefoneCelular());
		//Servicos
		newObj.setConsulta(obj.getConsulta());
		newObj.setExames(obj.getConsulta());
		newObj.setVacinacao(obj.getVacinacao());
		newObj.setBanhoETosa(obj.getBanhoETosa());
		newObj.setExames(obj.getExames());
		newObj.setCirurgiaGeral(obj.getCirurgiaGeral());
		newObj.setHidratacao(obj.getHidratacao());
		newObj.setPenteadosArtisticos(obj.getPenteadosArtisticos());
		newObj.setTosaExotica(obj.getTosaExotica());
		newObj.setAcupuntura(obj.getAcupuntura());
		newObj.setSpa(obj.getSpa());
		newObj.setHotel(obj.getHotel());
		newObj.setCreche(obj.getCreche());
		newObj.setTaxi(obj.getTaxi());
		newObj.setEnsaioFotografico(obj.getEnsaioFotografico());
		newObj.setAdestramento(obj.getAdestramento());
		newObj.setMassagem(obj.getMassagem());
		newObj.setPetwalk(obj.getPetwalk());
	}

	public URI uploadPicture(MultipartFile multipartFile) {
		
		UserSS user = UserService.authenticated(); // verifica se esta logado

		if(user == null){
			throw new AuthorizationException("Acesso negado");
		}


		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		String fileName = prefix + user.getId() + ".jpg";

		URI uri =  s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
		
		PetProvider pet = find(user.getId());
		pet.setFotoPerfil(uri.toString());
		petProviderRepository.save(pet);

		return uri;

	}


	public List<PetProvider> findByCidadeAndEstadoAndBairro(String cidade, String estado, String bairro) {
		return null;
	}

}
