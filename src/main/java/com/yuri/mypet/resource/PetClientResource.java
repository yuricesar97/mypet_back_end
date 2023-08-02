package com.yuri.mypet.resource;

import com.yuri.mypet.domain.PetClient;
import com.yuri.mypet.dto.PetClientDTO;
import com.yuri.mypet.dto.PetClientNewDTO;
import com.yuri.mypet.service.PetClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoafisica")
public class PetClientResource {

	@Autowired
	private PetClientService service;
	


	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	 ResponseEntity<PetClient> buscar(@PathVariable Integer id) {
		PetClient obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(
			@Valid @RequestBody PetClientNewDTO objDto) { /**
															 * requestBody faz o json ser convertido para obj java
															 * automaticamente
															 */
		PetClient obj = service.fromDto(objDto);// coverto Dto para objeto entidade
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}



    
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetClientDTO objDto,
			@PathVariable Integer id) {/**
										 * receber o obejto json e tambem o parametro da url
										 */
		PetClient obj = service.fromDto(objDto);
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

	@RequestMapping(value = "/email", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<PetClient> findEmail(@RequestParam(value="value") String email) {
		PetClient obj = service.findEmail(email);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetClientDTO>> findAll() {

		List<PetClient> list = service.findAll();
		List<PetClientDTO> listDto = list.stream().map(obj -> new PetClientDTO(obj)).collect(
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
	public ResponseEntity<Page<PetClientDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<PetClient> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PetClientDTO> listDto = list.map(obj -> new PetClientDTO(
				obj)); /**
						 * stream percorre a lista, map realiza uma operação para cada elemento da lista
						 */
		return ResponseEntity.ok().body(listDto); /**
													 * obj função anonima que recebece uma obj com argumento collector
													 * realiza a transformação para lista novamente
													 */
	}

	@CrossOrigin
	@RequestMapping(value="/picture", method = RequestMethod.POST)
	public ResponseEntity<Void> uploadPicture(@RequestParam(name = "file")MultipartFile file) {
		URI uri = service.uploadPicture(file);
		return ResponseEntity.created(uri).build();
	}

}
