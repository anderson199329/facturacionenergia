package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;

public class InformacionServicio implements Serializable{

	private static final long serialVersionUID = 3336944638537034877L;
	
	private String nombreOperacion;

	public String getNombreOperacion() {
		return nombreOperacion;
	}

	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}
	
}
