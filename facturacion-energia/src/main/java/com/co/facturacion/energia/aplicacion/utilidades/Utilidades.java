package com.co.facturacion.energia.aplicacion.utilidades;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.SQLGrammarException;

import com.co.facturacion.energia.aplicacion.bean.ClienteBean;
import com.co.facturacion.energia.aplicacion.bean.EstadoRespuesta;
import com.co.facturacion.energia.aplicacion.bean.FacturaBean;
import com.co.facturacion.energia.aplicacion.bean.InformacionServicio;
import com.co.facturacion.energia.aplicacion.bean.PagoBean;
import com.co.facturacion.energia.aplicacion.bean.RespuestaData;
import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.dominio.Cliente;
import com.co.facturacion.energia.aplicacion.dominio.Factura;
import com.co.facturacion.energia.aplicacion.dominio.Pago;

public class Utilidades {
	
	private static final int CODIGO_200 = 200;
	private static final int CODIGO_403 = 403;
	private static final int CODIGO_203 = 203;
	private static final int CODIGO_204 = 204;
	private static final int CODIGO_205 = 205;
	private static final String EXITOSO = "Exitoso";
	private static final String REGISTRO_EXISTENTE = "Usuario existente";
	private static final String ERROR = "Error";
	private static final String SIN_RESULTADO = "Sin Resultados";
	private static final String NO_AUTORIZADO = "No autorizado";
	
	
	public static RespuestaDataList errorRespuesta(InformacionServicio informacionServicio) {
		
		RespuestaDataList respuestaDataList = new RespuestaDataList();
		EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
		estadoRespuesta.setCodigoRespuesta(CODIGO_200);
		estadoRespuesta.setCodigoEstado(CODIGO_403);
		estadoRespuesta.setEstadoRespuesta(ERROR);
		respuestaDataList.setEstadoRespuesta(estadoRespuesta);
		respuestaDataList.setInformacionServicio(informacionServicio);
		return respuestaDataList;
		
	}
	
	public static RespuestaDataList respuestaExitosa(InformacionServicio informacionServicio) {
		
		RespuestaDataList respuestaDataList = new RespuestaDataList();
		EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
		estadoRespuesta.setCodigoRespuesta(CODIGO_200);
		estadoRespuesta.setEstadoRespuesta(EXITOSO);
		respuestaDataList.setEstadoRespuesta(estadoRespuesta);
		respuestaDataList.setInformacionServicio(informacionServicio);
		return respuestaDataList;
		
	}
	
	public static RespuestaDataList sinResultado(InformacionServicio informacionServicio) {
		
		RespuestaDataList respuestaDataList = new RespuestaDataList();
		EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
		estadoRespuesta.setCodigoRespuesta(CODIGO_200);
		estadoRespuesta.setCodigoEstado(CODIGO_204);
		estadoRespuesta.setEstadoRespuesta(SIN_RESULTADO);
		respuestaDataList.setEstadoRespuesta(estadoRespuesta);
		respuestaDataList.setInformacionServicio(informacionServicio);
		return respuestaDataList;
		
	}
	
	public static RespuestaDataList registroExistente(InformacionServicio informacionServicio) {
		
		RespuestaDataList respuestaDataList = new RespuestaDataList();
		EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
		estadoRespuesta.setCodigoRespuesta(CODIGO_200);
		estadoRespuesta.setCodigoEstado(CODIGO_205);
		estadoRespuesta.setEstadoRespuesta(REGISTRO_EXISTENTE);
		respuestaDataList.setEstadoRespuesta(estadoRespuesta);
		respuestaDataList.setInformacionServicio(informacionServicio);
		return respuestaDataList;
		
	}
	
public static RespuestaDataList noAutorizado(InformacionServicio informacionServicio) {
		
		RespuestaDataList respuestaDataList = new RespuestaDataList();
		EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
		estadoRespuesta.setCodigoRespuesta(CODIGO_200);
		estadoRespuesta.setCodigoEstado(CODIGO_203);
		estadoRespuesta.setEstadoRespuesta(NO_AUTORIZADO);
		respuestaDataList.setEstadoRespuesta(estadoRespuesta);
		respuestaDataList.setInformacionServicio(informacionServicio);
		return respuestaDataList;
		
	}
	
	public static Cliente adicionarCliente(ClienteBean clienteBean) {
		
		Cliente cliente = new Cliente();
		cliente.setCedulaNit(clienteBean.getCedulaNit());
		cliente.setCliente(clienteBean.getCliente());
		cliente.setEstrato(clienteBean.getEstrato());
		cliente.setTelefono(clienteBean.getTelefono());
		cliente.setCelular(clienteBean.getCelular());
		return cliente;
		
	}
	
	public static Factura adicionarFactura(FacturaBean facturaBean) {
		
		Factura factura = new Factura();
		factura.setNumero(facturaBean.getNumero());
		factura.setConsumo(facturaBean.getConsumo());
		factura.setMes(facturaBean.getMes());
		factura.setAno(facturaBean.getAno());
		factura.setTotalPagar(facturaBean.getTotalPagar());
		Cliente cliente = new Cliente();
		cliente.setId(facturaBean.getIdCliente());
		factura.setFkCliente(cliente);
		return factura;
		
	}
	
	public static Pago adicionarPago(PagoBean pagoBean) {
		
		Pago pago = new Pago();
		Factura factura = new Factura();
		factura.setId(pagoBean.getIdFactura());
		pago.setFkFactura(factura);
		LocalDateTime fecha = LocalDateTime.now();
		Timestamp fechaPago = Timestamp.valueOf(fecha);
		pago.setFechaPago(fechaPago);
		return pago;
		
	}
	
	public static Cliente actualizarCliente(Cliente cliente, ClienteBean clienteBean) {
		
		cliente.setCedulaNit(clienteBean.getCedulaNit());
		cliente.setCliente(clienteBean.getCliente());
		cliente.setEstrato(clienteBean.getEstrato());
		cliente.setCelular(clienteBean.getCelular());
		cliente.setTelefono(clienteBean.getTelefono());
		return cliente;
		
	}
		
	public static RespuestaDataList listaCliente(List<Cliente> listaCliente, InformacionServicio informacionServicio) {
		
		try {
			
			RespuestaDataList respuestaDataList = new RespuestaDataList();
			EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
			estadoRespuesta.setCodigoRespuesta(CODIGO_200);
			estadoRespuesta.setEstadoRespuesta(EXITOSO);
			respuestaDataList.setEstadoRespuesta(estadoRespuesta);
			respuestaDataList.setInformacionServicio(informacionServicio);
			
			List<ClienteBean> listaResultadoCliente = new ArrayList<ClienteBean>();
			ClienteBean objetoCliente;
			
			for(Cliente cliente : listaCliente) {
				
				objetoCliente = new ClienteBean();
				objetoCliente.setId(cliente.getId());
				objetoCliente.setCedulaNit(cliente.getCedulaNit());
				objetoCliente.setCliente(cliente.getCliente());
				objetoCliente.setTelefono(cliente.getTelefono());
				objetoCliente.setCelular(cliente.getCelular());
				objetoCliente.setEstrato(cliente.getEstrato());
				listaResultadoCliente.add(objetoCliente);
				
			}
			
			RespuestaData respuestaData = new RespuestaData();
			respuestaData.setCliente(listaResultadoCliente);
			respuestaDataList.setRespuestaData(respuestaData);
			return respuestaDataList;
		
		}catch (SQLGrammarException e) {
			System.err.println("[ClienteNegocio] ERROR ESQUEMA ENTITY-DOMAIN (Corroborar que las clases del domain tengan el atributo schema) ERROR::"+e);
			return errorRespuesta(informacionServicio);
		}catch (Exception e) {
			System.err.println("[ClienteNegocio] UNA DE LAS COLUMNAS OBLIGATORIAS EN BD ESTA NULL, ERROR LISTA:: "+e);
			return errorRespuesta(informacionServicio);
		}
		
	}
	
	public static RespuestaDataList listarFactura(List<Factura> listaFactura,InformacionServicio informacionServicio) {
		
		try {
		
			RespuestaDataList respuestaDataList = new RespuestaDataList();
			EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
			estadoRespuesta.setCodigoRespuesta(CODIGO_200);
			estadoRespuesta.setEstadoRespuesta(EXITOSO);
			respuestaDataList.setEstadoRespuesta(estadoRespuesta);
			respuestaDataList.setInformacionServicio(informacionServicio);
		
			List<FacturaBean> listaResultadoFactura = new ArrayList<FacturaBean>();
			FacturaBean objetoFactura;
			
			for (Factura factura : listaFactura) {
				
				objetoFactura = new FacturaBean();
				objetoFactura.setId(factura.getId());
				objetoFactura.setNumero(factura.getNumero());
				objetoFactura.setConsumo(factura.getConsumo());
				objetoFactura.setMes(factura.getMes());
				objetoFactura.setAno(factura.getAno());
				objetoFactura.setTotalPagar(factura.getTotalPagar());
				objetoFactura.setCliente(factura.getFkCliente().getCliente());
				listaResultadoFactura.add(objetoFactura);
				
			}
			
			RespuestaData respuestaData = new RespuestaData();
			respuestaData.setFactura(listaResultadoFactura);
			respuestaDataList.setRespuestaData(respuestaData);
			return respuestaDataList;
		
		}catch (SQLGrammarException e) {
			System.err.println("[FacturaNegocio] ERROR ESQUEMA ENTITY-DOMAIN (Corroborar que las clases del domain tengan el atributo schema) ERROR::"+e);
			return errorRespuesta(informacionServicio);
		}catch (Exception e) {
			System.err.println("[FacturaNegocio] UNA DE LAS COLUMNAS OBLIGATORIAS EN BD ESTA NULL, ERROR LISTA:: "+e);
			return errorRespuesta(informacionServicio);
		}
		
	}
	
	public static RespuestaDataList listaPago(List<Pago> listaPago, InformacionServicio informacionServicio) {
		
		try {
			
			RespuestaDataList respuestaDataList = new RespuestaDataList();
			EstadoRespuesta estadoRespuesta = new EstadoRespuesta();
			estadoRespuesta.setCodigoRespuesta(CODIGO_200);
			estadoRespuesta.setEstadoRespuesta(EXITOSO);
			respuestaDataList.setEstadoRespuesta(estadoRespuesta);
			respuestaDataList.setInformacionServicio(informacionServicio);
			
			List<PagoBean> listaResultadoPago = new ArrayList<PagoBean>();
			PagoBean objetoPago;
			
			for(Pago pago : listaPago) {
				
				objetoPago = new PagoBean();
				objetoPago.setId(pago.getId());
				objetoPago.setNumeroFactura(pago.getFkFactura().getNumero());
				objetoPago.setFechaPago(pago.getFechaPago());
				listaResultadoPago.add(objetoPago);
				
			}
			
			RespuestaData respuestaData = new RespuestaData();
			respuestaData.setPago(listaResultadoPago);
			respuestaDataList.setRespuestaData(respuestaData);
			return respuestaDataList;
			
		}catch (SQLGrammarException e) {
			System.err.println("[PagoNegocio] ERROR ESQUEMA ENTITY-DOMAIN (Corroborar que las clases del domain tengan el atributo schema) ERROR::"+e);
			return errorRespuesta(informacionServicio);
		}catch (Exception e) {
			System.err.println("[PagoNegocio] UNA DE LAS COLUMNAS OBLIGATORIAS EN BD ESTA NULL, ERROR LISTA:: "+e);
			return errorRespuesta(informacionServicio);
		}
		
	}

}
