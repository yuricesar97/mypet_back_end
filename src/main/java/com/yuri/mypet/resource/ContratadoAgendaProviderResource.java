package com.yuri.mypet.resource;



import com.yuri.mypet.domain.ContratadoAgendaProvider;
import com.yuri.mypet.dto.ContratadoAgendaProviderDTO;
import com.yuri.mypet.dto.ContratadoAgendaProviderNewDTO;
import com.yuri.mypet.service.ContratadoAgendaProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/contratadoprovider")
public class ContratadoAgendaProviderResource {

    @Autowired
    private ContratadoAgendaProviderService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
    public ResponseEntity<ContratadoAgendaProvider> buscar(@PathVariable Integer id) {
        ContratadoAgendaProvider obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    // RESOURCE PARA PETPROVIDER
    @RequestMapping(value = "/idPetProvider", method = RequestMethod.GET)
    public ResponseEntity<List<ContratadoAgendaProvider>> find(@RequestParam(value = "value") Integer idPetProvider) {
        List<ContratadoAgendaProvider> obj = service.findByIdPetProviderAndStatus(idPetProvider);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/historicoProvider", method = RequestMethod.GET)
    public ResponseEntity<List<ContratadoAgendaProvider>> findByIdPetProviderHistorico(
            @RequestParam(value = "value") Integer idPetProvider) {
        List<ContratadoAgendaProvider> obj = service.findByIdPetProviderHistorico(idPetProvider);
        return ResponseEntity.ok().body(obj);
    }


    // RESOURCE PARA PETCLIENT
    @RequestMapping(value = "/idPetCliente", method = RequestMethod.GET)
    public ResponseEntity<List<ContratadoAgendaProvider>> findIdClient(
            @RequestParam(value = "value") Integer idPetCliente) {
        List<ContratadoAgendaProvider> obj = service.findByIdPetClient(idPetCliente);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/historicoCliente", method = RequestMethod.GET)
    public ResponseEntity<List<ContratadoAgendaProvider>> findByIdPetClientHistorico(
            @RequestParam(value = "value") Integer idPetCliente) {
        List<ContratadoAgendaProvider> obj = service.findByIdPetClientHistorico(idPetCliente);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ResponseEntity<List<ContratadoAgendaProvider>> findStatus(
            @RequestParam(value = "value") boolean status) {
        List<ContratadoAgendaProvider> obj = service.findByStatus(status);
        return ResponseEntity.ok().body(obj);
    }
    /** 
    @RequestMapping(value="/idPetProvider/{status}", method=RequestMethod.GET)
    public ResponseEntity<ContratadoAgendaProvider> find(@RequestParam(value="idPetProvider") Integer idPetProvider,@RequestParam(value="status") boolean status) {
        ContratadoAgendaProvider obj = service.findByIdPetProviderAndStatus(idPetProvider,status);
        return ResponseEntity.ok().body(obj);
    }
    */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(
            @Valid @RequestBody ContratadoAgendaProviderNewDTO objDto) { /**
     * requestBody faz o json ser convertido para obj java
     * automaticamente
     */
        ContratadoAgendaProvider obj = service.fromDto(objDto);// coverto Dto para objeto entidade
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ContratadoAgendaProviderDTO objDto,
                                       @PathVariable Integer id) {/**
     * receber o obejto json e tambem o parametro da url
     */
        ContratadoAgendaProvider obj = service.fromDto(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // para bater em um end pont com id
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ContratadoAgendaProviderDTO>> findAll() {

        List<ContratadoAgendaProvider> list = service.findAll();
        List<ContratadoAgendaProviderDTO> listDto = list.stream().map(obj -> new ContratadoAgendaProviderDTO(obj)).collect(
                Collectors.toList()); /**
         * stream percorre a lista, map realiza uma operação para cada elemento da lista
         */
        return ResponseEntity.ok().body(listDto); /**
         * obj função anonima que recebece uma obj com argumento collector
         * realiza a transformação para lista novamente
         */
    }

    //	@CrossOrigin
    @RequestMapping(value = "/page", method = RequestMethod.GET) // paginação
    public ResponseEntity<Page<ContratadoAgendaProviderDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                                            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<ContratadoAgendaProvider> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ContratadoAgendaProviderDTO> listDto = list.map(obj -> new ContratadoAgendaProviderDTO(
                obj)); /**
         * stream percorre a lista, map realiza uma operação para cada elemento da lista
         */
        return ResponseEntity.ok().body(listDto); /**
         * obj função anonima que recebece uma obj com argumento collector
         * realiza a transformação para lista novamente
         */
    }

}
