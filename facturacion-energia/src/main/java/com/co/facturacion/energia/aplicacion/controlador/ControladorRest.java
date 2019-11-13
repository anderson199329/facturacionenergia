package com.co.facturacion.energia.aplicacion.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;
import com.co.facturacion.energia.aplicacion.negocio.ClienteInterface;
import com.co.facturacion.energia.aplicacion.negocio.FacturaInterface;
import com.co.facturacion.energia.aplicacion.negocio.InformeInterface;
import com.co.facturacion.energia.aplicacion.negocio.PagoInterface;

@RestController
@RequestMapping(path = "/facturacion")
@CrossOrigin(origins = {"http://localhost:4204"})
public class ControladorRest {
	
	private ClienteInterface clienteNegocio;
	private FacturaInterface facturaNegocio;
	private PagoInterface pagoNegocio;
	private InformeInterface informeNegocio;
	
	@Autowired
	public ControladorRest(ClienteInterface clienteNegocio, FacturaInterface facturaNegocio, PagoInterface pagoNegocio, InformeInterface informeNegocio) {
		
		this.clienteNegocio = clienteNegocio;
		this.facturaNegocio = facturaNegocio;
		this.pagoNegocio = pagoNegocio;
		this.informeNegocio = informeNegocio;
		
	}
	
	@PostMapping(value="/cliente/consultar")
	public RespuestaDataList consultarCliente(@Valid @RequestBody Solicitud solicitud) {
		
		return clienteNegocio.consultarCliente(solicitud);
		
	}
	
	@PostMapping(value="/cliente/adicionar")
	public RespuestaDataList adicionarCliente(@Valid @RequestBody Solicitud solicitud) {
		
		return clienteNegocio.adicionarCliente(solicitud);
		
	}
	
	@PostMapping(value="/cliente/actualizar")
	public RespuestaDataList actualizarCliente(@Valid @RequestBody Solicitud solicitud) {
		
		return clienteNegocio.actualizarCliente(solicitud);
		
	}
	
	@PostMapping(value="/cliente/eliminar")
	public RespuestaDataList eliminarCliente(@Valid @RequestBody Solicitud solicitud) {
		
		return clienteNegocio.eliminarCliente(solicitud);
		
	}
	
	@PostMapping(value="/factura/consultar")
	public RespuestaDataList consultarFactura(@Valid @RequestBody Solicitud solicitud) {
		
		return facturaNegocio.consultarFactura(solicitud);
		
	}
	
	@PostMapping(value="/factura/adicionar")
	public RespuestaDataList adicionarFactura(@Valid @RequestBody Solicitud solicitud) {
		
		return facturaNegocio.adicionarFactura(solicitud);
		
	}
	
	@PostMapping(value="/pago/consultar")
	public RespuestaDataList consultarPago(@Valid @RequestBody Solicitud solicitud) {
		
		return pagoNegocio.consultarPago(solicitud);
		
	}
	
	@PostMapping(value="/pago/listarFactura")
	public RespuestaDataList listarFactura(@Valid @RequestBody Solicitud solicitud) {
		
		return pagoNegocio.listarFacturaPendiente(solicitud);
		
	}
	
	@PostMapping(value="/pago/adicionar")
	public RespuestaDataList adicionarPago(@Valid @RequestBody Solicitud solicitud) {
		
		return pagoNegocio.adicionarPago(solicitud);
		
	}
	
	@PostMapping(value="/informe/clienteFactura")
	public RespuestaDataList clienteFactura(@Valid @RequestBody Solicitud solicitud) {
		
		return informeNegocio.detalleFacturaCliente(solicitud);
		
	}
	
	@PostMapping(value="/informe/historialConsumo")
	public RespuestaDataList historialConsumo(@Valid @RequestBody Solicitud solicitud) {
		
		return informeNegocio.historialConsumo(solicitud);
		
	}
	
	@PostMapping(value="/informe/consultarPagoFactura")
	public RespuestaDataList consultarPagoFactura(@Valid @RequestBody Solicitud solicitud) {
		
		return informeNegocio.consultarFacturaNoPaga(solicitud);
		
	}

}
