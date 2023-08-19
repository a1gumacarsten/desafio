package com.example.desafio.supplier.dto;

import java.util.List;

import com.example.desafio.telephone.dto.TelephoneDTO;
import com.example.desafio.supplier.enumeration.SupplierType;

public class SupplierDTO {

	private Long id;
	private String name;
	private String email;
	private List<TelephoneDTO> telephones;
	private SupplierType type;
	private String observation;
	private Boolean favorite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TelephoneDTO> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<TelephoneDTO> telephones) {
		this.telephones = telephones;
	}

	public SupplierType getType() {
		return type;
	}

	public void setType(SupplierType type) {
		this.type = type;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
}
