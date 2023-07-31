package com.yuri.mypet.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.service.validation.JuridicoUpdate;

@JuridicoUpdate
public class PetProviderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	/*
	 * @NotEmpty(message = "Prenchimento obrigatório")
	 * 
	 * @Length(min = 5, max = 120, message =
	 * "O tamanho deve ser entre 5 e 120 caracteres")
	 */
	private String razaoSocial;

	/*
	 * @NotEmpty(message = "Preechimento obrigatório")
	 * 
	 * @Email(message = "Email inválido")
	 */
	private String email;
	private String cpf;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	private String fotoPerfil;
	private String situacaoAprovacao;

	private String telefoneFixo;
	private String telefoneCelular;

	private boolean checkStatus = false;

	//Servicos que o fornecedor pode indicar que presta
	private String banhoETosa;
	private String vacinacao ;
	private String consulta ;
	private String exames;
	private String cirurgiaGeral ;
	private String hidratacao ;
	private String penteadosArtisticos ;
	private String tosaExotica;
	private String acupuntura ;
	private String spa ;
	private String hotel ;
	private String creche;
	private String taxi ;
	private String ensaioFotografico;
	private String adestramento ;
	private String massagem ;
	private String petwalk;

	@Column(name="is_active")
	private Boolean active;

	public PetProviderDTO(PetProvider obj) { // construtor sera respnosavel por instanciar um DTO com os dados que desejo

		id = obj.getId();
		razaoSocial = obj.getRazaoSocial();
		email = obj.getEmail();
		cpf = obj.getCpf();
		logradouro = obj.getLogradouro();
		numero = obj.getNumero();
		complemento = obj.getComplemento();
		cep = obj.getCep();
		bairro = obj.getBairro();
		cidade = obj.getCidade();
		estado = obj.getEstado();
		fotoPerfil = obj.getFotoPerfil();
		situacaoAprovacao = obj.getSituacaoAprovacao();
		active = obj.getActive();
		telefoneFixo = obj.getTelefoneFixo();
		telefoneCelular = obj.getTelefoneCelular();
		vacinacao = obj.getVacinacao();
		consulta = obj.getConsulta();
		exames = obj.getExames();
		banhoETosa = obj.getBanhoETosa();
		cirurgiaGeral = obj.getCirurgiaGeral();
		hidratacao = obj.getHidratacao();
		penteadosArtisticos = obj.getPenteadosArtisticos();
		tosaExotica = obj.getTosaExotica();
		acupuntura = obj.getAcupuntura();
		spa = obj.getSpa();
		hotel = obj.getHotel();
		creche = obj.getCreche();
		taxi = obj.getTaxi();
		ensaioFotografico = obj.getEnsaioFotografico();
		adestramento = obj.getAdestramento();
		massagem = obj.getMassagem();
		petwalk = obj.getPetwalk();

	}

	public PetProviderDTO() {

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSituacaoAprovacao() {
		return situacaoAprovacao;
	}

	public void setSituacaoAprovacao(String situacaoAprovacao) {
		this.situacaoAprovacao = situacaoAprovacao;
	}

	public boolean isCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getBanhoETosa() {
		return banhoETosa;
	}

	public void setBanhoETosa(String banhoETosa) {
		this.banhoETosa = banhoETosa;
	}

	public String getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(String vacinacao) {
		this.vacinacao = vacinacao;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public String getExames() {
		return exames;
	}

	public void setExames(String exames) {
		this.exames = exames;
	}

	public String getCirurgiaGeral() {
		return cirurgiaGeral;
	}

	public void setCirurgiaGeral(String cirurgiaGeral) {
		this.cirurgiaGeral = cirurgiaGeral;
	}

	public String getHidratacao() {
		return hidratacao;
	}

	public void setHidratacao(String hidratacao) {
		this.hidratacao = hidratacao;
	}

	public String getPenteadosArtisticos() {
		return penteadosArtisticos;
	}

	public void setPenteadosArtisticos(String penteadosArtisticos) {
		this.penteadosArtisticos = penteadosArtisticos;
	}

	public String getTosaExotica() {
		return tosaExotica;
	}

	public void setTosaExotica(String tosaExotica) {
		this.tosaExotica = tosaExotica;
	}

	public String getAcupuntura() {
		return acupuntura;
	}

	public void setAcupuntura(String acupuntura) {
		this.acupuntura = acupuntura;
	}

	public String getSpa() {
		return spa;
	}

	public void setSpa(String spa) {
		this.spa = spa;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getCreche() {
		return creche;
	}

	public void setCreche(String creche) {
		this.creche = creche;
	}

	public String getTaxi() {
		return taxi;
	}

	public void setTaxi(String taxi) {
		this.taxi = taxi;
	}

	public String getEnsaioFotografico() {
		return ensaioFotografico;
	}

	public void setEnsaioFotografico(String ensaioFotografico) {
		this.ensaioFotografico = ensaioFotografico;
	}

	public String getAdestramento() {
		return adestramento;
	}

	public void setAdestramento(String adestramento) {
		this.adestramento = adestramento;
	}

	public String getMassagem() {
		return massagem;
	}

	public void setMassagem(String massagem) {
		this.massagem = massagem;
	}

	public String getPetwalk() {
		return petwalk;
	}

	public void setPetwalk(String petwalk) {
		this.petwalk = petwalk;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	


}
