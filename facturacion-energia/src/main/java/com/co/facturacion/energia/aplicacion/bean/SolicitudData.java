package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;

public class SolicitudData implements Serializable{

	private static final long serialVersionUID = -4346254103429509439L;
	
	private ClienteBean cliente;
	private FacturaBean factura;
	private PagoBean pago;

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	
	public FacturaBean getFactura() {
		return factura;
	}

	public void setFactura(FacturaBean factura) {
		this.factura = factura;
	}

	public PagoBean getPago() {
		return pago;
	}

	public void setPago(PagoBean pago) {
		this.pago = pago;
	}
	
}
