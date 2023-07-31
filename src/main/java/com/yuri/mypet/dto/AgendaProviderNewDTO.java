package com.yuri.mypet.dto;

import java.io.Serializable;


public class AgendaProviderNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private boolean segundaCheck = false;
	private boolean tercaCheck = false;
	private boolean quartaCheck= false;
	private boolean quintaCheck = false;
	private boolean sextaCheck = false;
	private boolean sabadoCheck = false;
	private boolean domingoCheck = false;
	private String tempoInicio;
	private String tempoFim;
	private String siglaDia;
	private String tempoInicioCorrecao;
	private String tempoFimCorrecao;
	private String today;
	private String time;
	private boolean selecaoHorario;
	private String nomeCliente;
	private String nomeProvider;
	private String servicoEscolhido;
	private Integer idPetClient;
	private Integer idPetProvider;
	private String dataCalendarioCorrecao;
	private boolean escolhido;
	private Integer tempoInicioIntervalo;
	private Integer tempoFimIntervalo;
	

	public AgendaProviderNewDTO() {

	}

	

	public String getTempoInicio() {
		return tempoInicio;
	}

	public void setTempoInicio(String tempoInicio) {
		this.tempoInicio = tempoInicio;
	}

	public String getTempoFim() {
		return tempoFim;
	}

	public void setTempoFim(String tempoFim) {
		this.tempoFim = tempoFim;
	}

	public String getSiglaDia() {
		return siglaDia;
	}

	public void setSiglaDia(String siglaDia) {
		this.siglaDia = siglaDia;
	}

	public String getTempoInicioCorrecao() {
		return tempoInicioCorrecao;
	}

	public void setTempoInicioCorrecao(String tempoInicioCorrecao) {
		this.tempoInicioCorrecao = tempoInicioCorrecao;
	}

	public String getTempoFimCorrecao() {
		return tempoFimCorrecao;
	}

	public void setTempoFimCorrecao(String tempoFimCorrecao) {
		this.tempoFimCorrecao = tempoFimCorrecao;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	

	public void setSegundaCheck(boolean segundaCheck) {
		this.segundaCheck = segundaCheck;
	}

	public boolean isTercaCheck() {
		return tercaCheck;
	}

	public void setTercaCheck(boolean tercaCheck) {
		this.tercaCheck = tercaCheck;
	}

	public boolean isQuartaCheck() {
		return quartaCheck;
	}

	public void setQuartaCheck(boolean quartaCheck) {
		this.quartaCheck = quartaCheck;
	}

	public boolean isQuintaCheck() {
		return quintaCheck;
	}

	public void setQuintaCheck(boolean quintaCheck) {
		this.quintaCheck = quintaCheck;
	}

	public boolean isSextaCheck() {
		return sextaCheck;
	}

	public void setSextaCheck(boolean sextaCheck) {
		this.sextaCheck = sextaCheck;
	}

	public boolean isSabadoCheck() {
		return sabadoCheck;
	}

	public void setSabadoCheck(boolean sabadoCheck) {
		this.sabadoCheck = sabadoCheck;
	}

	public boolean isDomingoCheck() {
		return domingoCheck;
	}

	public void setDomingoCheck(boolean domingoCheck) {
		this.domingoCheck = domingoCheck;
	}

	public boolean isSegundaCheck() {
		return segundaCheck;
	}

	public boolean isSelecaoHorario() {
		return selecaoHorario;
	}

	public void setSelecaoHorario(boolean selecaoHorario) {
		this.selecaoHorario = selecaoHorario;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeProvider() {
		return nomeProvider;
	}

	public void setNomeProvider(String nomeProvider) {
		this.nomeProvider = nomeProvider;
	}

	public String getServicoEscolhido() {
		return servicoEscolhido;
	}

	public void setServicoEscolhido(String servicoEscolhido) {
		this.servicoEscolhido = servicoEscolhido;
	}

	public Integer getIdPetProvider() {
		return idPetProvider;
	}

	public void setIdPetProvider(Integer idPetProvider) {
		this.idPetProvider = idPetProvider;
	}

	public Integer getIdPetClient() {
		return idPetClient;
	}

	public void setIdPetClient(Integer idPetClient) {
		this.idPetClient = idPetClient;
	}

	/**
	 * @return the dataCalendarioCorrecao
	 */
	public String getDataCalendarioCorrecao() {
		return dataCalendarioCorrecao;
	}

	/**
	 * @param dataCalendarioCorrecao the dataCalendarioCorrecao to set
	 */
	public void setDataCalendarioCorrecao(String dataCalendarioCorrecao) {
		this.dataCalendarioCorrecao = dataCalendarioCorrecao;
	}

	public boolean isEscolhido() {
		return escolhido;
	}

	public void setEscolhido(boolean escolhido) {
		this.escolhido = escolhido;
	}

	public Integer getTempoInicioIntervalo() {
		return tempoInicioIntervalo;
	}

	public void setTempoInicioIntervalo(Integer tempoInicioIntervalo) {
		this.tempoInicioIntervalo = tempoInicioIntervalo;
	}

	public Integer getTempoFimIntervalo() {
		return tempoFimIntervalo;
	}

	public void setTempoFimIntervalo(Integer tempoFimIntervalo) {
		this.tempoFimIntervalo = tempoFimIntervalo;
	}

	
}
