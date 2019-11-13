package com.co.facturacion.energia.aplicacion.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pago", schema="energia")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(columnDefinition = "serial")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="fk_factura")
	private Factura fkFactura;
	
	@Column(name="fecha_pago")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPago;
	
	public Pago() {
		
	}

	public Integer getId() {
		return id;
	}

	public Factura getFkFactura() {
		return fkFactura;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFkFactura(Factura fkFactura) {
		this.fkFactura = fkFactura;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
}
