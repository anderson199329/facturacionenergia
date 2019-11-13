package com.co.facturacion.energia.aplicacion.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="factura", schema="energia")
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(columnDefinition = "serial")
	private Integer id;
	
	private Long numero;
	
	private Long consumo;
	
	private String mes;
	
	private int ano;
	
	@Column(name="total_pagar")
	private Double totalPagar;
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Cliente fkCliente;
	
	public Factura() {
		
	}

	public Integer getId() {
		return id;
	}

	public Long getNumero() {
		return numero;
	}

	public Long getConsumo() {
		return consumo;
	}

	public String getMes() {
		return mes;
	}
	
	public Double getTotalPagar() {
		return totalPagar;
	}

	public Cliente getFkCliente() {
		return fkCliente;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public void setConsumo(Long consumo) {
		this.consumo = consumo;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
