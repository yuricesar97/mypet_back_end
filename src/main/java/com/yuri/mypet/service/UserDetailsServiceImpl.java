package com.yuri.mypet.service;

import com.yuri.mypet.domain.LoginConjunto;
import com.yuri.mypet.repositories.LoginConjuntoRepository;
import com.yuri.mypet.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService { // permite busca pelo nome do usuario

	@Autowired
	private LoginConjuntoRepository loginConjuntoRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LoginConjunto loginConjunto = loginConjuntoRepository.findByEmail(email);

		if (loginConjunto == null) {
			throw new UsernameNotFoundException(email);
		}

		return new UserSS(loginConjunto.getId(), loginConjunto.getEmail(), loginConjunto.getSenha(),
				loginConjunto.getPerfis());
	}

}
