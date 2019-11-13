package com.co.facturacion.energia.aplicacion.bean;

import java.io.Serializable;
import java.util.List;

public class RespuestaData implements Serializable{

	private static final long serialVersionUID = 5849986563303793677L;
	
	private List<ClienteBean> cliente;
	private List<FacturaBean> factura;
	private List<PagoBean> pago;
	private List<ClienteFacturaBean> clienteFactura;

	public List<ClienteBean> getCliente() {
		return cliente;
	}

	public void setCliente(List<ClienteBean> cliente) {
		this.cliente = cliente;
	}

	public List<FacturaBean> getFactura() {
		return factura;
	}

	public void setFactura(List<FacturaBean> factura) {
		this.factura = factura;
	}

	public List<PagoBean> getPago() {
		return pago;
	}

	public void setPago(List<PagoBean> pago) {
		this.pago = pago;
	}

	public List<ClienteFacturaBean> getClienteFactura() {
		return clienteFactura;
	}

	public void setClienteFactura(List<ClienteFacturaBean> clienteFactura) {
		this.clienteFactura = clienteFactura;
	}
	
}
