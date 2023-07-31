package com.yuri.mypet.service;

import com.yuri.mypet.domain.ContratadoAgendaProvider;
import com.yuri.mypet.domain.PetClient;
import com.yuri.mypet.dto.ContratadoAgendaProviderDTO;
import com.yuri.mypet.dto.ContratadoAgendaProviderNewDTO;
import com.yuri.mypet.repositories.ContratadoAgendaProviderRepository;
import com.yuri.mypet.repositories.PetClientRepository;
import com.yuri.mypet.security.UserSS;
import com.yuri.mypet.service.exceptions.AuthorizationException;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContratadoAgendaProviderService {

    @Autowired
    ContratadoAgendaProviderRepository varContratadoProviderRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    @Autowired
    PetClientRepository petClientRepository;

    public PetClient findNomeClientById(Integer id) {



        Optional<PetClient> op = petClientRepository.findById(id);

        return op.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", tipo: " + PetClient.class.getName()));
    }


    // SERVICES PARA PETPROVIDER
    public List<ContratadoAgendaProvider> findByIdPetProviderAndStatus(Integer idPetProvider) {
		List<ContratadoAgendaProvider> op = varContratadoProviderRepository.findByIdPetProviderAndStatus(idPetProvider);
		
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! idPetProvider: " +idPetProvider + ", tipo: " + ContratadoAgendaProvider.class.getName());
		}
	return op;
    }

    public List<ContratadoAgendaProvider> findByIdPetProviderHistorico(Integer idPetProvider) {
        List<ContratadoAgendaProvider> op = varContratadoProviderRepository.findByHistoricoProvider(idPetProvider);

        if(op == null){
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! idPetClient: " +idPetProvider + ", tipo: " + ContratadoAgendaProvider.class.getName());
        }
        return op;
    }


    // SERVICES PARA PETCLIENT
    public List<ContratadoAgendaProvider> findByIdPetClient(Integer idPetClient) {
		List<ContratadoAgendaProvider> op = varContratadoProviderRepository.findByIdPetClient(idPetClient);
		
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! idPetClient: " +idPetClient + ", tipo: " + ContratadoAgendaProvider.class.getName());
		}
	return op;
    }

    public List<ContratadoAgendaProvider> findByIdPetClientHistorico(Integer idPetClient) {
        List<ContratadoAgendaProvider> op = varContratadoProviderRepository.findHistoricoClient(idPetClient);

        if(op == null){
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! idPetClient: " +idPetClient + ", tipo: " + ContratadoAgendaProvider.class.getName());
        }
        return op;
    }





    public List<ContratadoAgendaProvider> findByStatus(boolean status) {
		List<ContratadoAgendaProvider> op = varContratadoProviderRepository.findByStatus(status);
		
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! status: " + status + ", tipo: " + ContratadoAgendaProvider.class.getName());
		}
	return op;
    }
    /** 
    public ContratadoAgendaProvider findByIdPetProviderAndStatus (Integer idPetProvider, boolean status) {
		ContratadoAgendaProvider op = varContratadoProviderRepository.findByIdPetProviderAndStatus(idPetProvider,status);
		System.out.println("valllooooooor" + op);
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! idPetProvider: " +idPetProvider + ", tipo: " + ContratadoAgendaProvider.class.getName());
		}
	return op;
	}
    */

    public ContratadoAgendaProvider find(Integer id) {

		/*
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado ");
		}
		*/

        Optional<ContratadoAgendaProvider> op = varContratadoProviderRepository.findById(id);

        return op.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", tipo: " + ContratadoAgendaProvider.class.getName()));
    }





    @Transactional
    public ContratadoAgendaProvider insert(ContratadoAgendaProvider obj) {
        obj.setId(null);

        UserSS user = UserService.authenticated(); // verifica se esta logado

        if(user == null){
            throw new AuthorizationException("Acesso negado");
        }


        PetClient pet = findNomeClientById(user.getId());
        obj.setNomeCliente(pet.getNomeCompleto());
        obj.setIdPetClient(pet.getId());


        obj = varContratadoProviderRepository.save(obj);
        return obj;

    }

    public ContratadoAgendaProvider update(ContratadoAgendaProvider obj) {
        ContratadoAgendaProvider newObj = find(obj.getId()); // instanciar um cliente a parir do banco dados
        updateData(newObj, obj); // atulaiza os dados como o obj que foi enviado na requisição
        return varContratadoProviderRepository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            varContratadoProviderRepository.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataInternalException("Não é possivel exclui porque há pedidos relacionadas");
        }
    }

    public List<ContratadoAgendaProvider> findAll() {
        return varContratadoProviderRepository.findAll();
    }



    public Page<ContratadoAgendaProvider> findPage(Integer page, Integer linesPerPage, String orderBy,
                                         String direction) {/**
     * Page vai encapsular informações e operações sobre a paginação
     */

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy); /**
         * prepara as informações para que faça a consulta que retorne a pagina de dados
         */
        return varContratadoProviderRepository.findAll(pageRequest); // Direction convertendo do tipo String para o tipo Direction
    }

    public ContratadoAgendaProvider fromDto(ContratadoAgendaProviderDTO objDto) { /**
     * metado auxiliar que instacia uma categoria a partir de um DTO
     */

        return new ContratadoAgendaProvider(objDto.getId(), objDto.getNomeCliente(), objDto.getNomeProvider(),
                                            objDto.getDataEscolhida(), objDto.getTempoInicio(), objDto.getTempoFim(),
                                            objDto.getTipoService(), objDto.getSiglaDia(),
                objDto.getIdPetClient(), objDto.getIdPetProvider(), objDto.getDataCalendarioCorrecao(),objDto.isStatus(),
                objDto.isCancelado(),objDto.isNotificaCancelamento(),objDto.getMotivoCancelamento(),objDto.getMostraStatus());
    }

    public ContratadoAgendaProvider fromDto(ContratadoAgendaProviderNewDTO objDto) {

        return new ContratadoAgendaProvider(null, objDto.getNomeCliente(), objDto.getNomeProvider(),
                                            objDto.getDataEscolhida(), objDto.getTempoInicio(), objDto.getTempoFim(),
                                            objDto.getTipoService(), objDto.getSiglaDia(),
                objDto.getIdPetClient(), objDto.getIdPetProvider(), objDto.getDataCalendarioCorrecao(),objDto.isStatus(),
                objDto.isCancelado(), objDto.isNotificaCancelamento(),objDto.getMotivoCancelamento(),objDto.getMostraStatus());

    }


    private void updateData(ContratadoAgendaProvider newObj, ContratadoAgendaProvider obj) { /**
     * metado aux para atualizar os campos do cliente,
     * pegando o novo e colocando no antigo
     */
        newObj.setNomeCliente(obj.getNomeCliente());
        newObj.setNomeProvider(obj.getNomeProvider());
        newObj.setDataEscolhida(obj.getDataEscolhida());
        newObj.setTempoInicio(obj.getTempoInicio());
        newObj.setTempoFim(obj.getTempoFim());
        newObj.setTipoService(obj.getTipoService());
        newObj.setSiglaDia(obj.getSiglaDia());
        newObj.setTempoInicio(obj.getTempoInicio());
        newObj.setTempoFim(obj.getTempoFim());
        newObj.setSiglaDia(obj.getSiglaDia());
        newObj.setDataCalendarioCorrecao(obj.getDataCalendarioCorrecao());
        newObj.setCancelado(obj.isCancelado());
        newObj.setStatus(obj.isStatus());
        newObj.setNotificaCancelamento(obj.isNotificaCancelamento());
        newObj.setMotivoCancelamento(obj.getMotivoCancelamento());
    }
}
