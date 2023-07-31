package com.yuri.mypet.dto;

import com.yuri.mypet.domain.ContratadoAgendaProvider;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class ContratadoAgendaProviderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCliente ;
    private String nomeProvider;
    private Date dataEscolhida;
    private String tempoInicio;
    private String tempoFim;
    private String tipoService;
    private String siglaDia;
    private Integer idPetClient;
    private Integer idPetProvider;
    private String dataCalendarioCorrecao;
    private boolean status = false;
    private boolean cancelado = false;
    private String  mostraStatus;

     //notificação cancelamento 
    private boolean notificaCancelamento =false; 
    private String motivoCancelamento ;
    

    public ContratadoAgendaProviderDTO(ContratadoAgendaProvider varContratadoAgendaProvider)    {
        id = varContratadoAgendaProvider.getId();
        nomeCliente = varContratadoAgendaProvider.getNomeCliente();
        nomeProvider = varContratadoAgendaProvider.getNomeProvider();
        dataEscolhida = varContratadoAgendaProvider.getDataEscolhida();
        tempoInicio = varContratadoAgendaProvider.getTempoInicio();
        tempoFim = varContratadoAgendaProvider.getTempoFim();
        tipoService = varContratadoAgendaProvider.getTipoService();
        siglaDia = varContratadoAgendaProvider.getSiglaDia();
        idPetClient = varContratadoAgendaProvider.getIdPetClient();
        idPetProvider = varContratadoAgendaProvider.getIdPetProvider();
        dataCalendarioCorrecao = varContratadoAgendaProvider.getDataCalendarioCorrecao();
        status = varContratadoAgendaProvider.isStatus();
        cancelado = varContratadoAgendaProvider.isCancelado();
        notificaCancelamento = varContratadoAgendaProvider.isNotificaCancelamento();
        motivoCancelamento =varContratadoAgendaProvider.getMotivoCancelamento();
        mostraStatus = varContratadoAgendaProvider.getMostraStatus();
        
    }

    public ContratadoAgendaProviderDTO()    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDataEscolhida() {
        return dataEscolhida;
    }

    public void setDataEscolhida(Date dataEscolhida) {
        this.dataEscolhida = dataEscolhida;
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

    public String getTipoService() {
        return tipoService;
    }

    public void setTipoService(String tipoService) {
        this.tipoService = tipoService;
    }

    public String getSiglaDia() {
        return siglaDia;
    }

    public void setSiglaDia(String siglaDia) {
        this.siglaDia = siglaDia;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public boolean isNotificaCancelamento() {
        return notificaCancelamento;
    }

    public void setNotificaCancelamento(boolean notificaCancelamento) {
        this.notificaCancelamento = notificaCancelamento;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public String getMostraStatus() {
        return mostraStatus;
    }

    public void setMostraStatus(String mostraStatus) {
        this.mostraStatus = mostraStatus;
    }
    
}


