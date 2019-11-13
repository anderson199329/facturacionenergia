package com.co.facturacion.energia.aplicacion.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.co.facturacion.energia.aplicacion.bean.InformacionServicio;
import com.co.facturacion.energia.aplicacion.bean.PagoBean;
import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;
import com.co.facturacion.energia.aplicacion.repositorio.FacturaRepositorio;
import com.co.facturacion.energia.aplicacion.repositorio.PagoRepositorio;
import com.co.facturacion.energia.aplicacion.utilidades.Utilidades;
import com.co.facturacion.energia.aplicacion.dominio.Factura;
import com.co.facturacion.energia.aplicacion.dominio.Pago;

@Service
public class PagoNegocio implements PagoInterface{
	
	private PagoRepositorio pagoRepositorio;
	private FacturaRepositorio facturaRepositorio;
	
	@Autowired
	public PagoNegocio(PagoRepositorio pagoRepositorio, FacturaRepositorio facturaRepositorio) {
		
		this.pagoRepositorio = pagoRepositorio;
		this.facturaRepositorio = facturaRepositorio;
		
	}

	@Override
	public RespuestaDataList consultarPago(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = solicitud.getInformacionServicio();
		
		try {
			
			List<Pago> listaPago = pagoRepositorio.encontrarPago();
			
			if (null != listaPago && listaPago.size() > 0) {
				
				return Utilidades.listaPago(listaPago, informacionServicio);
				
			}else {
			
				return Utilidades.sinResultado(informacionServicio);
			
			}
		
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[PagoNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[PagoNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[PagoNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
	}

	@Override
	public RespuestaDataList listarFacturaPendiente(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = solicitud.getInformacionServicio();
		
		try {
		
			List<Factura> listaFactura = facturaRepositorio.encontrarFacturaPendiente();
			
			if (null != listaFactura && listaFactura.size() > 0) {
				
				return Utilidades.listarFactura(listaFactura, informacionServicio);
				
			}else {
			
				return Utilidades.sinResultado(informacionServicio);
			
			}
		
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[PagoNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[PagoNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[PagoNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
		
	}

	@Override
	public RespuestaDataList adicionarPago(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = new InformacionServicio();
		
		try {
			
			PagoBean pagoBean = solicitud.getSolicitudData().getPago();
			
			pagoRepositorio.save(Utilidades.adicionarPago(pagoBean));
			return Utilidades.respuestaExitosa(informacionServicio);
			
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[PagoNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[PagoNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[PagoNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
		
	}
	
}
