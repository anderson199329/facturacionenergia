package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;

public class Solicitud implements Serializable{

	private static final long serialVersionUID = 6945613053037830964L;
	
	private SolicitudData solicitudData;
	private InformacionServicio informacionServicio;
	
	public SolicitudData getSolicitudData() {
		return solicitudData;
	}
	
	public InformacionServicio getInformacionServicio() {
		return informacionServicio;
	}
	
	public void setSolicitudData(SolicitudData solicitudData) {
		this.solicitudData = solicitudData;
	}
	
	public void setInformacionServicio(InformacionServicio informacionServicio) {
		this.informacionServicio = informacionServicio;
	}
	
}
