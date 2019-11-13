package com.co.facturacion.energia.aplicacion.negocio;

import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;

public interface InformeInterface {
	
	public RespuestaDataList detalleFacturaCliente(Solicitud solicitud);
	
	public RespuestaDataList historialConsumo(Solicitud solicitud);
	
	public RespuestaDataList consultarFacturaNoPaga(Solicitud solicitud);

}
