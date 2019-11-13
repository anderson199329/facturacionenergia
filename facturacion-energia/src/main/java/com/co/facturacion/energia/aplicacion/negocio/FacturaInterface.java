package com.co.facturacion.energia.aplicacion.negocio;

import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;

public interface FacturaInterface {
	
	public RespuestaDataList consultarFactura(Solicitud solicitud);
	
	public RespuestaDataList adicionarFactura(Solicitud solicitud);

}
