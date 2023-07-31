package com.yuri.mypet.domain;

import static com.yuri.mypet.domain.enums.TipoCliente.toEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;

@Entity
// @Where(clause="is_active=1")
public class PetClient extends LoginConjunto {
	private static final long serialVersionUID = 1L;

	// dados do cliente
	private String username;
	private String nomeCompleto;
	private String cpf;
	private Integer tipoPerfil;
	private String fotoPerfil;
	private String descricao;
	private String dataNascimento;
	private Boolean active;
	// dados de endereco
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	// dados de contato
	private String telefoneFixo;
	private String telefoneCelular;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER) // traz o perfil junto
	@CollectionTable(name = "PERFIS_PETCLIENT")
	private Set<Integer> cliente = new HashSet<>();

	public PetClient() {
		addPerfil(Perfil.CLIENTE);
	}

	public PetClient(Integer id, String username, String nomeCompleto, String email, String cpf, TipoCliente tipoPerfil,
			Perfil perfil, String senha, String fotoPerfil, String descricao, String dataNascimento, String logradouro,
			String numero, String complemento, String bairro, String cep, String cidade, String estado, Boolean active,
			String telefoneFixo, String telefoneCelular) {
		super(id, email, senha, perfil, active);

		this.username = username;

		this.cpf = cpf;
		this.tipoPerfil = (tipoPerfil == null) ? null
				: tipoPerfil.getCod(); /**
										 * operador ternario .. na intaciação não aceita nullo precisa de uma
										 * condicional por conta do getCod
										 */

		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.fotoPerfil = fotoPerfil;
		this.descricao = descricao;
		this.dataNascimento = dataNascimento;
		this.nomeCompleto = nomeCompleto;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.active = active;
		addPerfil(Perfil.CLIENTE);

	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoCliente getTipoPerfil() {
		return toEnum(tipoPerfil);
	}

	public Set<Perfil> getPerfis() {
		return cliente.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());

	}

	public void addPerfil(Perfil perfil) {
		cliente.add(perfil.getCod());
	}

	public void setTipoPerfil(TipoCliente tipoPerfil) {
		this.tipoPerfil = tipoPerfil.getCod();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
