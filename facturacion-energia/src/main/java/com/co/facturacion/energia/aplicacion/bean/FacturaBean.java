package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;

public class FacturaBean implements Serializable{

	private static final long serialVersionUID = -8149193117204494028L;
	
	private int id;
	private long numero;
	private long consumo;
	private String mes;
	private int ano;
	private double totalPagar;
	private String cliente;
	private int idCliente;
	
	public FacturaBean() {
		
	}

	public int getId() {
		return id;
	}

	public long getNumero() {
		return numero;
	}

	public long getConsumo() {
		return consumo;
	}

	public String getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public String getCliente() {
		return cliente;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public void setConsumo(long consumo) {
		this.consumo = consumo;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
}
