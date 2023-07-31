package com.yuri.mypet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PetServices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String descricao;
	private String petService;

	public PetServices() {

	}

	public PetServices(Integer id, String descricao, String petService) {
		this.id = id;
		this.descricao = descricao;
		this.petService = petService;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPetService() {
		return petService;
	}

	public void setPetService(String petService) {
		this.petService = petService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
