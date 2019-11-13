package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;

public class EstadoRespuesta implements Serializable{

	private static final long serialVersionUID = 3252321697524069227L;
	
	private int codigoRespuesta;
	private int codigoEstado;
	private String estadoRespuesta;
	
	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}
	
	public int getCodigoEstado() {
		return codigoEstado;
	}
	
	public String getEstadoRespuesta() {
		return estadoRespuesta;
	}
	
	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	
	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	
	public void setEstadoRespuesta(String estadoRespuesta) {
		this.estadoRespuesta = estadoRespuesta;
	}
	
}
