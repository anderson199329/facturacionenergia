package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;

public class RespuestaDataList implements Serializable{

	private static final long serialVersionUID = 7143989737912856489L;
	
	private RespuestaData respuestaData;
	private EstadoRespuesta estadoRespuesta;
	private InformacionServicio informacionServicio;
	
	public RespuestaData getRespuestaData() {
		return respuestaData;
	}
	
	public EstadoRespuesta getEstadoRespuesta() {
		return estadoRespuesta;
	}
	
	public InformacionServicio getInformacionServicio() {
		return informacionServicio;
	}
	
	public void setRespuestaData(RespuestaData respuestaData) {
		this.respuestaData = respuestaData;
	}
	
	public void setEstadoRespuesta(EstadoRespuesta estadoRespuesta) {
		this.estadoRespuesta = estadoRespuesta;
	}
	
	public void setInformacionServicio(InformacionServicio informacionServicio) {
		this.informacionServicio = informacionServicio;
	}
	
}
