package com.co.facturacion.energia.aplicacion.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.co.facturacion.energia.aplicacion.bean.ClienteFacturaBean;
import com.co.facturacion.energia.aplicacion.bean.EstadoRespuesta;
import com.co.facturacion.energia.aplicacion.bean.FacturaBean;
import com.co.facturacion.energia.aplicacion.bean.InformacionServicio;
import com.co.facturacion.energia.aplicacion.bean.RespuestaData;
import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;
import com.co.facturacion.energia.aplicacion.dominio.Cliente;
import com.co.facturacion.energia.aplicacion.dominio.Factura;
import com.co.facturacion.energia.aplicacion.dominio.Pago;
import com.co.facturacion.energia.aplicacion.repositorio.ClienteRepositorio;
import com.co.facturacion.energia.aplicacion.repositorio.FacturaRepositorio;
import com.co.facturacion.energia.aplicacion.repositorio.PagoRepositorio;
import com.co.facturacion.energia.aplicacion.utilidades.Utilidades;

@Service
public class InformeNegocio implements InformeInterface{
	
	private ClienteRepositorio clienteRepositorio;
	private FacturaRepositorio facturaRepositorio;
	private PagoRepositorio pagoRepositorio;
	
	@Autowired
	public InformeNegocio(ClienteRepositorio clienteRepositorio, FacturaRepositorio facturaRepositorio, PagoRepositorio pagoRepositorio) {
		
		this.clienteRepositorio = clienteRepositorio;
		this.facturaRepositorio = facturaRepositorio;
		this.pagoRepositorio = pagoRepositorio;
		
	}

	@Override
	public RespuestaDataList detalleFacturaCliente(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = solicitud.getInformacionServicio();
		
		try {
			
			List<Cliente> listaCliente = clienteRepositorio.encontrarCliente();
			List<ClienteFacturaBean> listaResultadoCliente = new ArrayList<ClienteFacturaBean>();
			ClienteFacturaBean objetoCliente;
			
			if(null != listaCliente && listaCliente.size() > 0) {
				
				for(Cliente cliente : listaCliente) {
					
					objetoCliente = new ClienteFacturaBean();
					objetoCliente.setId(cliente.getId());
					objetoCliente.setCedulaNit(cliente.getCedulaNit());
					objetoCliente.setCliente(cliente.getCliente());
					objetoCliente.setTelefono(cliente.getTelefono());
					objetoCliente.setCelular(cliente.getCelular());
					objetoCliente.setEstrato(cliente.getEstrato());
					List<Factura> facturaPaga = facturaRepositorio.facturaPagaUsuario(cliente.getId());
					List<Long> FacturaPagaLong = new ArrayList<Long>();
					if (null != facturaPaga) {
						for (Factura facturaPagaObj : facturaPaga) {
							FacturaPagaLong.add(facturaPagaObj.getNumero());
						}
					}
					objetoCliente.setFacturaPaga(FacturaPagaLong);
					List<Factura> facturaPendientePago = facturaRepositorio.encontrarFacturaPendienteUsuario(cliente.getId());
					List<Long> FacturaPendienteLong = new ArrayList<Long>();
					if (null != facturaPendientePago) {
						for (Factura facturaPendienteObj : facturaPendientePago) {
							FacturaPendienteLong.add(facturaPendienteObj.getNumero());
						}
					}
					objetoCliente.setFacturaPendientePago(FacturaPendienteLong);
					listaResultadoCliente.add(objetoCliente);
				}
				
			}
			
			RespuestaDataList respuestaDataList = new RespuestaDataList();
			EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
			estadoRespuesta.setCodigoRespuesta(200);
			estadoRespuesta.setEstadoRespuesta("Exitoso");
			respuestaDataList.setEstadoRespuesta(estadoRespuesta);
			respuestaDataList.setInformacionServicio(informacionServicio);
			RespuestaData respuestaData = new RespuestaData();
			respuestaData.setClienteFactura(listaResultadoCliente);
			respuestaDataList.setRespuestaData(respuestaData);
			return respuestaDataList;
			
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[InformeNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[InformeNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[InformeNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
			
	}

	@Override
	public RespuestaDataList historialConsumo(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = solicitud.getInformacionServicio();
		
		try {
			
			int cliente = solicitud.getSolicitudData().getCliente().getId();
			List<Factura> historialConsumo = facturaRepositorio.historialConsumo(cliente);
			List<FacturaBean> listaResultadoConsumo = new ArrayList<FacturaBean>();
			FacturaBean facturaObj;
			RespuestaDataList respuestaDataList = new RespuestaDataList();
			EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
			
			if(null != historialConsumo && historialConsumo.size() > 0) {
				
				for(Factura factura : historialConsumo) {
					
					facturaObj = new FacturaBean();
					facturaObj.setId(factura.getId());
					facturaObj.setNumero(factura.getNumero());
					facturaObj.setConsumo(factura.getConsumo());
					facturaObj.setMes(factura.getMes());
					facturaObj.setAno(factura.getAno());
					listaResultadoConsumo.add(facturaObj);
				
				}
				
				estadoRespuesta.setCodigoRespuesta(200);
				estadoRespuesta.setEstadoRespuesta("Exitoso");
				respuestaDataList.setEstadoRespuesta(estadoRespuesta);
				
			}else {
				
				estadoRespuesta.setCodigoRespuesta(200);
				estadoRespuesta.setCodigoEstado(204);
				estadoRespuesta.setEstadoRespuesta("Sin resultado");
				respuestaDataList.setEstadoRespuesta(estadoRespuesta);
				
			}
			
			respuestaDataList.setInformacionServicio(informacionServicio);
			RespuestaData respuestaData = new RespuestaData();
			respuestaData.setFactura(listaResultadoConsumo);
			respuestaDataList.setRespuestaData(respuestaData);
			return respuestaDataList;
			
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[InformeNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[InformeNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[InformeNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
		
		
	}

	@Override
	public RespuestaDataList consultarFacturaNoPaga(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = solicitud.getInformacionServicio();
		
		try {
			
			long numeroFactura = solicitud.getSolicitudData().getFactura().getNumero();
			Factura factura = facturaRepositorio.encontrarNumero(numeroFactura);
			RespuestaDataList respuestaDataList = new RespuestaDataList();
			EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
			List<FacturaBean> listaResultadoFactura = new ArrayList<FacturaBean>();
			FacturaBean facturaObjeto = new FacturaBean();
			
			if (null != factura) {
			
				Pago pago = pagoRepositorio.encontrarFacturaPaga(factura.getId());
				
				if(null != pago) {
					
					estadoRespuesta.setCodigoRespuesta(200);
					estadoRespuesta.setCodigoEstado(205);
					estadoRespuesta.setEstadoRespuesta("registro existente");
					respuestaDataList.setEstadoRespuesta(estadoRespuesta);
					
				}else {
					
					facturaObjeto.setTotalPagar(factura.getTotalPagar());
					listaResultadoFactura.add(facturaObjeto);
					estadoRespuesta.setCodigoRespuesta(200);
					estadoRespuesta.setEstadoRespuesta("Exitoso");
					respuestaDataList.setEstadoRespuesta(estadoRespuesta);
					
				}
			
			}else {
				
				estadoRespuesta.setCodigoRespuesta(200);
				estadoRespuesta.setCodigoEstado(204);
				estadoRespuesta.setEstadoRespuesta("Sin resultado");
				respuestaDataList.setEstadoRespuesta(estadoRespuesta);
				
			}
			
			respuestaDataList.setInformacionServicio(informacionServicio);
			RespuestaData respuestaData = new RespuestaData();
			respuestaData.setFactura(listaResultadoFactura);
			respuestaDataList.setRespuestaData(respuestaData);
			return respuestaDataList;
		
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[InformeNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[InformeNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[InformeNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
		
	}
	
	

}
