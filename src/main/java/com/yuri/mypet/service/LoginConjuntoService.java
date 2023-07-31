package com.yuri.mypet.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuri.mypet.domain.LoginConjunto;
import com.yuri.mypet.domain.PagamentoComBoleto;
import com.yuri.mypet.dto.LoginConjutoDTO;
import com.yuri.mypet.repositories.LoginConjuntoRepository;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;

@Service
public class LoginConjuntoService {

	@Autowired
	private LoginConjuntoRepository loginConjuntoRepository;



	public LoginConjunto find(Integer id) {

		/*
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado ");
		}
		*/
		
		Optional<LoginConjunto> op = loginConjuntoRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + LoginConjunto.class.getName()));
	}


	public LoginConjunto findByEmail(String email) {
		LoginConjunto op = loginConjuntoRepository.findByEmail(email);
		System.out.println("valllooooooor" + op);
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! id: " +email + ", tipo: " + LoginConjunto.class.getName());
		}
	return op;
	}

	public Optional<LoginConjunto> findByEmailId(String email) {
		Optional<LoginConjunto> op = loginConjuntoRepository.findByEmailId(email);
		System.out.println("valllooooooor" + op);
		if(op == null){
		throw new ObjectNotFoundException(
			"Objeto não encontrado! id: " +email + ", tipo: " + LoginConjunto.class.getName());
		}
	return op;
	}


	public List<LoginConjunto> findAllEvent() {
		return loginConjuntoRepository.findAll();
	}

}
