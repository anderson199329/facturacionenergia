package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;
import java.util.List;

public class ClienteFacturaBean implements Serializable{

	private static final long serialVersionUID = -6985611261042598966L;
	
	private int id;
	private long cedulaNit;
	private String cliente;
	private long telefono;
	private long celular;
	private int estrato;
	private List<Long> facturaPaga;
	private List<Long> facturaPendientePago;
	 
	public ClienteFacturaBean() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	}

	public List<Long> getFacturaPaga() {
		return facturaPaga;
	}

	public List<Long> getFacturaPendientePago() {
		return facturaPendientePago;
	}

	public void setFacturaPaga(List<Long> facturaPaga) {
		this.facturaPaga = facturaPaga;
	}

	public void setFacturaPendientePago(List<Long> facturaPendientePago) {
		this.facturaPendientePago = facturaPendientePago;
	}
	
}
