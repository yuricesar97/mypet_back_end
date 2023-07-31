package com.yuri.mypet.domain;

import javax.persistence.Entity;

import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;

@Entity
public class PetProvider extends LoginConjunto {
	
	//ID do fornecedor
	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	private String cpf;
	private Integer tipoPerfil;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	private String telefoneFixo;
	private String telefoneCelular;

	private String fotoPerfil;
	private String situacaoAprovacao;

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

	public PetProvider() {
		addPerfil(Perfil.SERVICO);
	}

	public PetProvider(Integer id, String razaoSocial, String email, String cpf, TipoCliente tipoPerfil, Perfil perfil, String senha,		
	String fotoPerfil, String situacaoAprovacao, String banhoETosa, String vacinacao, String consulta, String exames, String cirurgiaGeral, 
	String hidratacao, String penteadosArtisticos, String tosaExotica, String acupuntura, String spa, String hotel, String creche, String taxi, 
	String ensaioFotografico, String adestramento, String massagem, String petwalk, boolean checkStatus, String logradouro, String numero, String complemento, 
	String bairro, String cep, String cidade, String estado, Boolean active, String telefoneFixo, String telefoneCelular) {	
			
			super(id, email, senha, perfil, active);

			this.razaoSocial = razaoSocial;
			this.cpf = cpf;
			this.tipoPerfil = (tipoPerfil == null) ? null : tipoPerfil.getCod();

			this.logradouro = logradouro;
			this.numero = numero;
			this.complemento = complemento;
			this.bairro = bairro;
			this.cep = cep;
			this.cidade = cidade;
			this.estado = estado;

			this.telefoneFixo = telefoneFixo;
			this.telefoneCelular = telefoneCelular;

			this.fotoPerfil = fotoPerfil;
			this.situacaoAprovacao = situacaoAprovacao;
			addPerfil(Perfil.SERVICO);
			
			//servicos
			this.banhoETosa = banhoETosa;
			this.vacinacao = vacinacao;
			this.consulta = consulta;
			this.exames = exames;
			this.cirurgiaGeral = cirurgiaGeral;
			this.hidratacao = hidratacao;
			this.penteadosArtisticos = penteadosArtisticos;
			this.tosaExotica = tosaExotica;
			this.acupuntura = acupuntura;
			this.spa = spa;
			this.hotel = hotel;
			this.creche = creche;
			this.taxi = taxi;
			this.ensaioFotografico = ensaioFotografico;
			this.adestramento = adestramento;
			this.massagem = massagem;
			this.petwalk = petwalk;
			
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

	public TipoCliente getTipoPerfil() {
		return TipoCliente.toEnum(tipoPerfil);
	}

	public void setTipoPerfil(TipoCliente tipoPerfil) {
		this.tipoPerfil = tipoPerfil.getCod();
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

}
