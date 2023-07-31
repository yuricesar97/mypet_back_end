package com.yuri.mypet.dto;

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

public class LoginConjutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String senha;
    private Boolean active;
    private Perfil perfil;


    public LoginConjutoDTO(LoginConjunto varEventProvider) {
        id = varEventProvider.getId();
        email = varEventProvider.getEmail();
        senha = varEventProvider.getSenha();
        active = varEventProvider.getActive();
        perfil = varEventProvider.getPerfil();
    }

    public LoginConjutoDTO() {

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    
}
