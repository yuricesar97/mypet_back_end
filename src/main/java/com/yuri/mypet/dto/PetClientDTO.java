package com.yuri.mypet.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.yuri.mypet.domain.EnderecoFisico;
import com.yuri.mypet.domain.PetClient;
import com.yuri.mypet.service.validation.ClienteUpdate;

@ClienteUpdate
public class PetClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;


	/** 
	@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")*/
	private String nomeCompleto;
 	/** 
	@NotEmpty(message = "Preechimento obrigatório")
	@Email(message = "Email inválido")*/
	private String email;
	private String senha;
	private String cpf;
	private String dataNascimento;
	private EnderecoFisico endereco;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	private String telefoneFixo;
	private String telefoneCelular;

	private boolean petWalker = false;
	private String descricao;
	
	@Column(name="is_active")
	private Boolean active = true;

	public PetClientDTO() {

	}

	public PetClientDTO(PetClient obj) { // construtor sera respnosavel por instanciar um DTO com os dados que
											// desejo

		id = obj.getId();
		nomeCompleto = obj.getNomeCompleto();
		email = obj.getEmail();
		cpf = obj.getCpf();
		dataNascimento = obj.getDataNascimento();
		senha = obj.getSenha();
		logradouro = obj.getLogradouro();
		numero = obj.getNumero();
		complemento = obj.getComplemento();
		bairro = obj.getBairro();
		cep = obj.getCep();
		cidade = obj.getCidade();
		estado = obj.getEstado();
		dataNascimento = obj.getDataNascimento();
		active = obj.getActive();
		telefoneFixo = obj.getTelefoneFixo();
		telefoneCelular = obj.getTelefoneCelular();
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoFisico getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoFisico endereco) {
		this.endereco = endereco;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
