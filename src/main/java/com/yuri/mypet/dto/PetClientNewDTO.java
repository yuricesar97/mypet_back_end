package com.yuri.mypet.dto;

import com.yuri.mypet.service.validation.ClienteInsert;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteInsert
public class PetClientNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	@NotEmpty(message = "Preechimento obrigatório")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nomeCompleto;

	private boolean petWalker = false;
	private String descricao;

	@NotEmpty(message = "Preechimento obrigatório")
	private String cpf;

	private String DataNascimento;

	private Integer tipoPerfil;
	private Integer perfil;

	@NotEmpty(message = "Preechimento obrigatório")
	private String senha;

	@NotEmpty(message = "Preechimento obrigatório")

	private String logradouro;
	@NotEmpty(message = "Preechimento obrigatório")

	@NotEmpty(message = "Preechimento obrigatório")
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	private String telefoneFixo;
	private String telefoneCelular;

	@NotEmpty(message = "Preechimento obrigatório")
	private String cep;

	private String telefone2;
	private String telefone3;

	@Column(name="is_active")
	private Boolean active;

	public PetClientNewDTO() {

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(Integer tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
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


	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
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

	public boolean isPetWalker() {
		return petWalker;
	}

	public void setPetWalker(boolean petWalker) {
		this.petWalker = petWalker;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
