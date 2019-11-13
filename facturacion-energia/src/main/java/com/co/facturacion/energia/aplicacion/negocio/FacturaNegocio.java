package com.co.facturacion.energia.aplicacion.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.co.facturacion.energia.aplicacion.bean.FacturaBean;
import com.co.facturacion.energia.aplicacion.bean.InformacionServicio;
import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;
import com.co.facturacion.energia.aplicacion.repositorio.FacturaRepositorio;
import com.co.facturacion.energia.aplicacion.utilidades.Utilidades;
import com.co.facturacion.energia.aplicacion.dominio.Factura;;

@Service
public class FacturaNegocio implements FacturaInterface{
	
	private FacturaRepositorio facturaRepositorio;
	
	@Autowired
	public FacturaNegocio(FacturaRepositorio facturaRepositorio) {
		
		this.facturaRepositorio = facturaRepositorio;
		
	}

	@Override
	public RespuestaDataList consultarFactura(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = solicitud.getInformacionServicio();
		
		try {
			
			List<Factura> listaFactura = facturaRepositorio.encontrarFactura();
			
			if (null != listaFactura && listaFactura.size() > 0) {
				
				return Utilidades.listarFactura(listaFactura, informacionServicio);
				
			}else {
				
				return Utilidades.sinResultado(informacionServicio);
				
			}
			
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[FacturaNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[FacturaNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[FacturaNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
		
	}

	@Override
	public RespuestaDataList adicionarFactura(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = new InformacionServicio();
		
		try {
			
			FacturaBean facturaBean = solicitud.getSolicitudData().getFactura();
			long numero = solicitud.getSolicitudData().getFactura().getNumero();
			int usuario = solicitud.getSolicitudData().getFactura().getIdCliente();
			String mes = solicitud.getSolicitudData().getFactura().getMes();
			int ano = solicitud.getSolicitudData().getFactura().getAno();
			Factura numeroFactura = facturaRepositorio.encontrarNumero(numero);
			
			if (numeroFactura == null) {
				
				Factura facturaMesAno = facturaRepositorio.facturaUsuarioMesAno(usuario, mes, ano);
				
				if(facturaMesAno == null) {
				
					facturaRepositorio.save(Utilidades.adicionarFactura(facturaBean));
					return Utilidades.respuestaExitosa(informacionServicio);
					
				}else {
					
					return Utilidades.noAutorizado(informacionServicio);
					
				}
				
			}else {
			
				return Utilidades.registroExistente(informacionServicio);
			
			}
			
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[FacturaNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[FacturaNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[FacturaNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
		
	}

}
