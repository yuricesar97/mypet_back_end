package com.yuri.mypet.dto;

import com.yuri.mypet.domain.AgendaProvider;
import com.yuri.mypet.domain.EventProvider;
import com.yuri.mypet.domain.LoginConjunto;
import com.yuri.mypet.domain.enums.Perfil;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class AgendaProviderDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
	private boolean selecaoHorario = false;
	private String nomeCliente;
	private String nomeProvider;
	private String servicoEscolhido;
    private Integer idPetClient;
    private Integer idPetProvider;
    private String dataCalendarioCorrecao;
    private boolean escolhido;
    private Integer tempoInicioIntervalo;
    private Integer tempoFimIntervalo;

    public AgendaProviderDTO(AgendaProvider agendaProvider) {
        id = agendaProvider.getId();
        segundaCheck = agendaProvider.isSegundaCheck();
        tercaCheck = agendaProvider.isTercaCheck();
        quartaCheck = agendaProvider.isQuartaCheck();
        quintaCheck = agendaProvider.isQuintaCheck();
        sextaCheck = agendaProvider.isSextaCheck();
        sabadoCheck = agendaProvider.isSabadoCheck();
        domingoCheck = agendaProvider.isDomingoCheck();
        tempoInicio = agendaProvider.getTempoInicio();
        tempoFim = agendaProvider.getTempoFim();
        siglaDia = agendaProvider.getSiglaDia();
        tempoInicioCorrecao = agendaProvider.getTempoInicioCorrecao();
        tempoFimCorrecao = agendaProvider.getTempoFimCorrecao();
        today = agendaProvider.getToday();
        time = agendaProvider.getTime();
        selecaoHorario = agendaProvider.isSelecaoHorario();
        nomeCliente = agendaProvider.getNomeCliente();
        nomeProvider = agendaProvider.getNomeProvider();
        servicoEscolhido = agendaProvider.getServicoEscolhido();
        idPetClient = agendaProvider.getIdPetClient();
        idPetProvider = agendaProvider.getIdPetProvider();
        dataCalendarioCorrecao = agendaProvider.getDataCalendarioCorrecao();
        escolhido = agendaProvider.isEscolhido();
        tempoInicioIntervalo = agendaProvider.getTempoInicioIntervalo();
        tempoFimIntervalo = agendaProvider.getTempoFimIntervalo();
    }

    public AgendaProviderDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTempoInicioCorrecao() {
        return tempoInicioCorrecao;
    }

    public void setTempoInicioCorrecao(String tempoInicioCorrecao) {
        this.tempoInicioCorrecao = tempoInicioCorrecao;
    }

    public boolean isSegundaCheck() {
        return segundaCheck;
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

    public Integer getIdPetClient() {
        return idPetClient;
    }

    public void setIdPetClient(Integer idPetClient) {
        this.idPetClient = idPetClient;
    }

    public Integer getIdPetProvider() {
        return idPetProvider;
    }

    public void setIdPetProvider(Integer idPetProvider) {
        this.idPetProvider = idPetProvider;
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


