package com.co.facturacion.energia.aplicacion.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="cliente", schema="energia")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(columnDefinition = "serial")
	private Integer id;
	
	@Column(name="cc_nit")
	private Long cedulaNit;
	
	private String cliente;
	
	private Long telefono;
	
	private Long celular;
	
	private Integer estrato;
	
	public Cliente() {
		
	}

	public Integer getId() {
		return id;
	}

	public Long getCedulaNit() {
		return cedulaNit;
	}

	public String getCliente() {
		return cliente;
	}

	public Long getTelefono() {
		return telefono;
	}

	public Long getCelular() {
		return celular;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCedulaNit(Long cedulaNit) {
		this.cedulaNit = cedulaNit;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Integer getEstrato() {
		return estrato;
	}

	public void setEstrato(Integer estrato) {
		this.estrato = estrato;
	};
	
}
