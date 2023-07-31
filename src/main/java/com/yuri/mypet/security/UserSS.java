package com.yuri.mypet.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.yuri.mypet.domain.enums.Perfil;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSS() {

	}

	public UserSS(Integer id, String email, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao()))
				.collect(Collectors.toList());
		System.out.println("Credenciais: " + "username: " + email + "Senha: " + senha + "perfil: " + authorities);
	}

	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {
		
		return senha;
	}

	@Override
	public String getUsername() {
		
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {

		// para uma futuro, ver se a conta do usuario expira ou não (tempo logado)

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// conta bloqueada
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// credenciais vencidas
		return true;
	}

	@Override
	public boolean isEnabled() {
		// usuario esta ativo
		return true;
	}

	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
