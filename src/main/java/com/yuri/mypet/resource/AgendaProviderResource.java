package com.yuri.mypet.resource;

import com.yuri.mypet.domain.AgendaProvider;
import com.yuri.mypet.dto.AgendaProviderDTO;
import com.yuri.mypet.dto.AgendaProviderNewDTO;
import com.yuri.mypet.service.AgendaProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/agendaprovider")
public class AgendaProviderResource {

	@Autowired
	private AgendaProviderService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(
			@Valid @RequestBody AgendaProviderNewDTO objDto) { /**
															 * requestBody faz o json ser convertido para obj java
															 * automaticamente
															 */
		AgendaProvider obj = service.fromDto(objDto);// coverto Dto para objeto entidade
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

    
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AgendaProviderDTO objDto,
			@PathVariable Integer id) {
		AgendaProvider obj = service.fromDto(objDto);
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
	public ResponseEntity<List<AgendaProviderDTO>> findAll() {

		List<AgendaProvider> list = service.findAll();
		List<AgendaProviderDTO> listDto = list.stream().map(obj -> new AgendaProviderDTO(obj)).collect(
				Collectors.toList()); /**
										 * stream percorre a lista, map realiza uma operação para cada elemento da lista
										 */
		return ResponseEntity.ok().body(listDto); /**
													 * obj função anonima que recebece uma obj com argumento collector
													 * realiza a transformação para lista novamente
													 */
	}

	@RequestMapping(value = "/idPetProvider", method = RequestMethod.GET)
	public ResponseEntity<List<AgendaProvider>> findAgendaPetProvider(@RequestParam(value = "value") Integer idPetProvider) {

		List<AgendaProvider> obj = service.findAgendaPetProvider(idPetProvider);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/selecionadosProvider", method = RequestMethod.GET) 
	public ResponseEntity<List<AgendaProvider>> findDiasSelecionados(@RequestParam(value = "idPetProvider") Integer idPetProvider,
																	 @RequestParam(value = "segundaCheck") boolean segundaCheck,
																	 @RequestParam(value = "tercaCheck") boolean tercaCheck,
																	 @RequestParam(value = "quartaCheck") boolean quartaCheck,
																	 @RequestParam(value = "quintaCheck") boolean quintaCheck,
																	 @RequestParam(value = "sextaCheck") boolean sextaCheck,
																	 @RequestParam(value = "sabadoCheck") boolean sabadoCheck,
																	 @RequestParam(value = "domingoCheck") boolean domingoCheck,
																	 @RequestParam(value = "dataCalendarioCorrecao") String dataCalendarioCorrecao,
																	 @RequestParam(value = "servicoEscolhido") String servicoEscolhido,
																	 @RequestParam(value = "tempoInicioCorrecao") String tempoInicioCorrecao,
																	 @RequestParam(value = "tempoFimCorrecao") String tempoFimCorrecao,
																	 @RequestParam(value = "siglaDia") String siglaDia) {

		List<AgendaProvider> obj = service.findDiasSelecionados(idPetProvider, segundaCheck,tercaCheck,quartaCheck,quintaCheck,
																sextaCheck,sabadoCheck,domingoCheck,
																dataCalendarioCorrecao, servicoEscolhido,
																tempoInicioCorrecao, tempoFimCorrecao, siglaDia);
		return ResponseEntity.ok().body(obj);
	}

//	@CrossOrigin
	@RequestMapping(value = "/page", method = RequestMethod.GET) // paginação
	public ResponseEntity<Page<AgendaProviderDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<AgendaProvider> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AgendaProviderDTO> listDto = list.map(obj -> new AgendaProviderDTO(
				obj)); /**
						 * stream percorre a lista, map realiza uma operação para cada elemento da lista
						 */
		return ResponseEntity.ok().body(listDto); /**
													 * obj função anonima que recebece uma obj com argumento collector
													 * realiza a transformação para lista novamente
													 */
	}

	

}
