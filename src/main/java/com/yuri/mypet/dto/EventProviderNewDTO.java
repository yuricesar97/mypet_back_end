package com.yuri.mypet.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EventProviderNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeEvento;
    private String dataEvento;
    private String nomeProvider;
    private String nomeClient;

    private String title;
    private String description;
    private String start;
    private String end;

    public EventProviderNewDTO() {

    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getNomeProvider() {
        return nomeProvider;
    }

    public void setNomeProvider(String nomeProvider) {
        this.nomeProvider = nomeProvider;
    }

    public String getNomeClient() {
        return nomeClient;
    }

    public void setNomeClient(String nomeClient) {
        this.nomeClient = nomeClient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
