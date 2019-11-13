package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;

public class ClienteBean implements Serializable{

	private static final long serialVersionUID = -3298550121886333518L;
	
	private int id;
	private long cedulaNit;
	private String cliente;
	private long telefono;
	private long celular;
	private int estrato;
	
	public ClienteBean() {
		
	}

	public int getId() {
		return id;
	}

	public long getCedulaNit() {
		return cedulaNit;
	}

	public String getCliente() {
		return cliente;
	}

	public long getTelefono() {
		return telefono;
	}

	public long getCelular() {
		return celular;
	}

	public int getEstrato() {
		return estrato;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCedulaNit(long cedulaNit) {
		this.cedulaNit = cedulaNit;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	};
	
}
