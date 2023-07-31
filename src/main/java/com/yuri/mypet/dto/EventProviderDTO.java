package com.yuri.mypet.dto;

import com.yuri.mypet.domain.EventProvider;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

public class EventProviderDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

 

    private String title;
    private String description;
    private String start;
    private String end;

    public EventProviderDTO(EventProvider varEventProvider) {
        id = varEventProvider.getId();
        title = varEventProvider.getTitle();
        description = varEventProvider.getDescription();
        start = varEventProvider.getStart();
        end = varEventProvider.getEnd();
    }

    public EventProviderDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
