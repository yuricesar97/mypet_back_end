package com.yuri.mypet.service;

import com.yuri.mypet.domain.AgendaProvider;
import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.dto.AgendaProviderDTO;
import com.yuri.mypet.dto.AgendaProviderNewDTO;
import com.yuri.mypet.repositories.AgendaProviderRepository;
import com.yuri.mypet.repositories.PetProviderRepository;
import com.yuri.mypet.security.UserSS;
import com.yuri.mypet.service.exceptions.AuthorizationException;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaProviderService {

	@Autowired
	AgendaProviderRepository agendaProviderRepository;

	@Autowired
	PetProviderRepository petProviderRepository;

	public PetProvider findNomeProviderById(Integer id) {

		Optional<PetProvider> op = petProviderRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetProvider.class.getName()));
	}
	//-------------FIND AGENDA PELO ID DO FORNECEDOR--------------------
	public List<AgendaProvider> findAgendaPetProvider(Integer idPetProvider) {
		List<AgendaProvider> op = agendaProviderRepository.findByIdPetProvider(idPetProvider);

		if(op == null){
			throw new ObjectNotFoundException(
					"Objeto não encontrado! idPetProvider: " +idPetProvider + ", tipo: " + AgendaProvider.class.getName());
		}
		return op;
	}
	//-------------FIND AGENDA PELO findDiasSelecionados--------------------
	public List<AgendaProvider> findDiasSelecionados(Integer idPetProvider, boolean segundaCheck,boolean tercaCheck,boolean quartaCheck,
													boolean quintaCheck,boolean sextaCheck,boolean sabadoCheck,boolean domingoCheck,
													 String dataCalendarioCorrecao, String servicoEscolhido,
													 String tempoInicioCorrecao, String tempoFimCorrecao, String siglaDia) {

		List<AgendaProvider> op = agendaProviderRepository.findDiasSelecionados(idPetProvider, segundaCheck,tercaCheck,quartaCheck
																				,quintaCheck,sextaCheck,sabadoCheck,domingoCheck,dataCalendarioCorrecao, servicoEscolhido,
																				tempoInicioCorrecao, tempoFimCorrecao, siglaDia);


		if(op == null){
			throw new ObjectNotFoundException(
					"Objeto não encontrado! idPetProvider: " +idPetProvider + ", tipo: " + AgendaProvider.class.getName());
		}
		return op;
	}


	public AgendaProvider find(Integer id) {

		/*
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado ");
		}
		*/

		Optional<AgendaProvider> op = agendaProviderRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + AgendaProvider.class.getName()));
	}




	@Transactional /**
	 * para que tudo ocorra de forma trasicional (salava endereço e cliente em uma
	 * tra)
	 */
	public AgendaProvider insert(AgendaProvider obj) {
		obj.setId(null);


		UserSS user = UserService.authenticated(); // verifica se esta logado

		if(user == null){
			throw new AuthorizationException("Acesso negado");
		}

		PetProvider  pet = findNomeProviderById(user.getId());
		obj.setNomeProvider(pet.getRazaoSocial());
		obj.setIdPetProvider(pet.getId());




		obj = agendaProviderRepository.save(obj); /**
		 * salva cliente enderecoRepository.saveAll(obj.getEndereço()); // salva
		 * endereço
		 */
		return obj;
	}

	public AgendaProvider update(AgendaProvider obj) {
		AgendaProvider newObj = find(obj.getId()); // instanciar um cliente a parir do banco dados
		updateData(newObj, obj); // atulaiza os dados como o obj que foi enviado na requisição
		return agendaProviderRepository.save(newObj); /**
		 * save vale quanto para inserir quanto para update unica coisa que
		 * ele olha é se o Id esta nulo ele insere se não atualiza
		 */
	}

	public void delete(Integer id) {
		find(id);
		try {
			agendaProviderRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há pedidos relacionadas");
		}
	}

	public List<AgendaProvider> findAll() {
		return agendaProviderRepository.findAll();
	}



	public Page<AgendaProvider> findPage(Integer page, Integer linesPerPage, String orderBy,
										 String direction) {/**
	 * Page vai encapsular informações e operações sobre a paginação
	 */

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),
				orderBy); /**
		 * prepara as informações para que faça a consulta que retorne a pagina de dados
		 */
		return agendaProviderRepository.findAll(pageRequest); // Direction convertendo do tipo String para o tipo Direction
	}

	public AgendaProvider fromDto(AgendaProviderDTO objDto) { /**
	 * metado auxiliar que instacia uma categoria a partir de um DTO
	 */

		return new AgendaProvider(objDto.getId(), objDto.isSegundaCheck(),objDto.isTercaCheck(),
				objDto.isQuartaCheck(), objDto.isQuintaCheck(),objDto.isSextaCheck(), objDto.isSabadoCheck(),
				objDto.isDomingoCheck(),objDto.getTempoInicio(),objDto.getTempoFim(),objDto.getSiglaDia(),objDto.getTempoInicioCorrecao(),
				objDto.getTempoFimCorrecao(),objDto.getToday(),objDto.getTime(), objDto.isSelecaoHorario(), objDto.getNomeCliente(),
				objDto.getNomeProvider(), objDto.getServicoEscolhido(), objDto.getIdPetClient(), objDto.getIdPetProvider(), objDto.getDataCalendarioCorrecao(),
				objDto.isEscolhido(), objDto.getTempoInicioIntervalo(), objDto.getTempoFimIntervalo());
	}

	public AgendaProvider fromDto(AgendaProviderNewDTO objDto) {

		return new AgendaProvider(null, objDto.isSegundaCheck(),objDto.isTercaCheck(),
				objDto.isQuartaCheck(), objDto.isQuintaCheck(),objDto.isSextaCheck(), objDto.isSabadoCheck(),
				objDto.isDomingoCheck(),objDto.getTempoInicio(),objDto.getTempoFim(),objDto.getSiglaDia(),objDto.getTempoInicioCorrecao(),
				objDto.getTempoFimCorrecao(),objDto.getToday(),objDto.getTime(), objDto.isSelecaoHorario(), objDto.getNomeCliente(),
				objDto.getNomeProvider(), objDto.getServicoEscolhido(), objDto.getIdPetClient(), objDto.getIdPetProvider(), objDto.getDataCalendarioCorrecao(),
				objDto.isEscolhido(), objDto.getTempoInicioIntervalo(), objDto.getTempoFimIntervalo());

	}


	private void updateData(AgendaProvider newObj, AgendaProvider obj) {
		newObj.setSegundaCheck(obj.isSegundaCheck());
		newObj.setTercaCheck(obj.isTercaCheck());
		newObj.setQuartaCheck(obj.isQuartaCheck());
		newObj.setQuintaCheck(obj.isQuintaCheck());
		newObj.setSextaCheck(obj.isSextaCheck());
		newObj.setSabadoCheck(obj.isSabadoCheck());
		newObj.setDomingoCheck(obj.isDomingoCheck());
		newObj.setTempoInicio(obj.getTempoInicio());
		newObj.setTempoFim(obj.getTempoFim());
		newObj.setSiglaDia(obj.getSiglaDia());
		newObj.setTempoInicioCorrecao(obj.getTempoInicioCorrecao());
		newObj.setTempoFimCorrecao(obj.getTempoFimCorrecao());
		newObj.setToday(obj.getToday());
		newObj.setTime(obj.getTime());
		newObj.setSelecaoHorario(obj.isSelecaoHorario());
		newObj.setNomeCliente(obj.getNomeCliente());
		newObj.setNomeProvider(obj.getNomeProvider());
		newObj.setIdPetClient(obj.getIdPetClient());
		newObj.setIdPetProvider(obj.getIdPetProvider());
		newObj.setDataCalendarioCorrecao(obj.getDataCalendarioCorrecao());
		newObj.setEscolhido(obj.isEscolhido());
		newObj.setTempoInicioIntervalo(obj.getTempoInicioIntervalo());
		newObj.setTempoFimIntervalo(obj.getTempoFimIntervalo());
	}


}
