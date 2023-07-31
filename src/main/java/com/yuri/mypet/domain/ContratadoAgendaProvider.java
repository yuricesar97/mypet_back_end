package com.yuri.mypet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ContratadoAgendaProvider implements Serializable {

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
    //notificação cancelamento 

    private boolean notificaCancelamento =false; 
    private String motivoCancelamento ;

    // finalizado ou cancelado 

    private String  mostraStatus;

    public ContratadoAgendaProvider()   {

    }

    public ContratadoAgendaProvider(Integer id, String nomeCliente, String nomeProvider, Date dataEscolhida,
                                    String tempoInicio, String tempoFim, String tipoService, String siglaDia,
                                    Integer idPetClient, Integer idPetProvider, String dataCalendarioCorrecao,boolean status,
                                    boolean cancelado,boolean notificaCancelamento,String motivoCancelamento,String  mostraStatus)   {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.nomeProvider = nomeProvider;
        this.dataEscolhida = dataEscolhida;
        this.tempoInicio = tempoInicio;
        this.tempoFim = tempoFim;
        this.tipoService = tipoService;
        this.siglaDia = siglaDia;
        this.idPetClient = idPetClient;
        this.idPetProvider = idPetProvider;
        this.dataCalendarioCorrecao = dataCalendarioCorrecao;
        this.status = status;
        this.cancelado = cancelado;
        this.motivoCancelamento = motivoCancelamento;
        this.notificaCancelamento = notificaCancelamento;
        this.mostraStatus = mostraStatus;

    }

    @Override
    public String toString() {
        return "AgendaProvider [id=" + id + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContratadoAgendaProvider other = (ContratadoAgendaProvider) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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
