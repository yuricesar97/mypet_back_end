package com.yuri.mypet.resource;

import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.dto.PetProviderDTO;
import com.yuri.mypet.dto.PetProviderNewDTO;
import com.yuri.mypet.service.PetProviderService;
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
@RequestMapping(value = "/pessoajuridica")
public class PetProviderResource {

	@Autowired
	private PetProviderService petProviderService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PetProvider> buscar(@PathVariable Integer id) {
		PetProvider obj = petProviderService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetProviderNewDTO objDto) {

		PetProvider obj = petProviderService.fromDto(objDto);
		obj = petProviderService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetProviderDTO objDto, @PathVariable Integer id) {
		PetProvider obj = petProviderService.fromDto(objDto);
		obj.setId(id);
		obj = petProviderService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/bairoAndCidade", method = RequestMethod.GET)
	public ResponseEntity<List<PetProviderDTO>> findByCidadeAndEstado(@RequestParam("cidade") String cidade,
			@RequestParam("estado") String estado) {
		List<PetProvider> list = petProviderService.findByCidadeAndEstado(cidade, estado);
		List<PetProviderDTO> listDto = list.stream().map(obj -> new PetProviderDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/razaoSocialAndCidadeAndBairro", method = RequestMethod.GET)
	public ResponseEntity<List<PetProviderDTO>> findByCidadeAndEstado(@RequestParam("cidade") String cidade,
			@RequestParam("razaoSocial") String razaoSocial, @RequestParam("bairro") String bairro ) {
		List<PetProvider> list = petProviderService.findByCidadeAndEstadoAndBairros(cidade, razaoSocial,bairro);
		List<PetProviderDTO> listDto = list.stream().map(obj -> new PetProviderDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


	@RequestMapping(value = "/razaoSocialAndCidade", method = RequestMethod.GET)
	public ResponseEntity<List<PetProviderDTO>> findByCidadeAndRazaoSocial(@RequestParam("cidade") String cidade,
																	  @RequestParam("razaoSocial") String razaoSocial ) {

		List<PetProvider> list = petProviderService.findByCidadeAndRazaoSocial(cidade, razaoSocial);
		List<PetProviderDTO> listDto = list.stream().map(obj -> new PetProviderDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		petProviderService.delete(id);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetProviderDTO>> findAll() {

		List<PetProvider> list = petProviderService.findAll();
		List<PetProviderDTO> listDto = list.stream().map(obj -> new PetProviderDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}


  //	@CrossOrigin
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<PetProviderDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<PetProvider> list = petProviderService.findPage(page, linesPerPage, orderBy, direction);
		Page<PetProviderDTO> listDto = list.map(obj -> new PetProviderDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

	@CrossOrigin
	@RequestMapping(value="/picture", method = RequestMethod.POST)
	public ResponseEntity<Void> uploadPicture(@RequestParam(name = "file")MultipartFile file) {
		URI uri = petProviderService.uploadPicture(file);
		return ResponseEntity.created(uri).build();
	}

}
