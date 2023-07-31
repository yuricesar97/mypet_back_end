package com.yuri.mypet.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.yuri.mypet.domain.LoginConjunto;
import com.yuri.mypet.dto.LoginConjutoDTO;
import com.yuri.mypet.repositories.LoginConjuntoRepository;
import com.yuri.mypet.service.LoginConjuntoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/loginConjunto")
public class LoginConjuntoResource {

	@Autowired
	private LoginConjuntoService service;



	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<LoginConjunto> buscar(@PathVariable Integer id) {
		LoginConjunto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/email", method=RequestMethod.GET)
 public ResponseEntity<LoginConjunto> find(@RequestParam(value="value") String email) {
	LoginConjunto obj = service.findByEmail(email);
 	return ResponseEntity.ok().body(obj);
 }
 @RequestMapping(value="/emailId", method=RequestMethod.GET)
 public ResponseEntity<Optional<LoginConjunto>> findEmail(@RequestParam(value = "value") String email) {
	Optional<LoginConjunto> obj = service.findByEmailId(email);
 	return ResponseEntity.ok().body(obj);
 }

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<LoginConjutoDTO>> findAllEvent() {

		List<LoginConjunto> list = service.findAllEvent();
		List<LoginConjutoDTO> listDto = list.stream().map(obj -> new LoginConjutoDTO(obj)).collect(
				Collectors.toList()); /**
										 * stream percorre a lista, map realiza uma operação para cada elemento da lista
										 */
		return ResponseEntity.ok().body(listDto); /**
													 * obj função anonima que recebece uma obj com argumento collector
													 * realiza a transformação para lista novamente
													 */
	}

	

}
