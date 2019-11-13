package com.co.facturacion.energia.aplicacion.negocio;

import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;

public interface ClienteInterface {
	
	public RespuestaDataList consultarCliente(Solicitud solicitud);
	
	public RespuestaDataList adicionarCliente(Solicitud solicitud);
	
	public RespuestaDataList actualizarCliente(Solicitud solicitud);
	
	public RespuestaDataList eliminarCliente(Solicitud solicitud);
	

}
