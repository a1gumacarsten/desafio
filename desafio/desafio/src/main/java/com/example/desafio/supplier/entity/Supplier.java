package com.example.desafio.supplier.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.desafio.telephone.Telephone;
import com.example.desafio.supplier.enumeration.SupplierType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supplier")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Supplier implements Serializable {

	public Supplier() {}
	
	public Supplier(Long id, String name, String email, List<Telephone> telephones, SupplierType type,
			String observation, Boolean favorite) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephones = telephones;
		this.type = type;
		this.observation = observation;
		this.favorite = favorite;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(name = "name")
	private String name;

	@Basic
	@Column(name = "email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "supplier_id")
	private List<Telephone> telephones;

	@Basic
	@Column(name = "type")
	private SupplierType type;

	@Basic
	@Column(name = "observation")
	private String observation;

	@Basic
	@Column(name = "favorite")
	private boolean favorite;

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

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
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
