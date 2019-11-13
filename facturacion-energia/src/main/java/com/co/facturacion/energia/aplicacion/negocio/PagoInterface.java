package com.co.facturacion.energia.aplicacion.negocio;

import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;

public interface PagoInterface {
	
	public RespuestaDataList consultarPago(Solicitud solicitud);
	
	public RespuestaDataList listarFacturaPendiente(Solicitud solicitud);
	
	public RespuestaDataList adicionarPago(Solicitud solicitud);

}
