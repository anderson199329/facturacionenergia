package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;
import java.util.Date;

public class PagoBean implements Serializable{

	private static final long serialVersionUID = 8000639444871591369L;
	
	private int id;
	private long numeroFactura;
	private Date fechaPago;
	private int idFactura;
	
	public PagoBean() {
		
	}

	public int getId() {
		return id;
	}

	public long getNumeroFactura() {
		return numeroFactura;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumeroFactura(long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
}
