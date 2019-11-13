package com.co.facturacion.energia.aplicacion.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.co.facturacion.energia.aplicacion.bean.ClienteBean;
import com.co.facturacion.energia.aplicacion.bean.InformacionServicio;
import com.co.facturacion.energia.aplicacion.bean.RespuestaDataList;
import com.co.facturacion.energia.aplicacion.bean.Solicitud;
import com.co.facturacion.energia.aplicacion.repositorio.ClienteRepositorio;
import com.co.facturacion.energia.aplicacion.utilidades.Utilidades;
import com.co.facturacion.energia.aplicacion.dominio.Cliente;


@Service
public class ClienteNegocio implements ClienteInterface{
	
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	public ClienteNegocio(ClienteRepositorio clienteRepositorio) {
		
		this.clienteRepositorio = clienteRepositorio;
		
	}

	@Override
	public RespuestaDataList consultarCliente(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = solicitud.getInformacionServicio();
		
		try {
			
			List<Cliente> listaCliente = clienteRepositorio.encontrarCliente();
			
			if (null != listaCliente && listaCliente.size() > 0) {
				
				return Utilidades.listaCliente(listaCliente, informacionServicio);
				
			}else {
				
				return Utilidades.sinResultado(informacionServicio);
				
			}
			
			
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[ClienteNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[ClienteNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[ClienteNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
	
	}

	@Override
	public RespuestaDataList adicionarCliente(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = new InformacionServicio();
		
		try {
			
			ClienteBean clienteBean = solicitud.getSolicitudData().getCliente();
			long identificacion = solicitud.getSolicitudData().getCliente().getCedulaNit();
			String nombre = solicitud.getSolicitudData().getCliente().getCliente();
			
			Cliente cliente = clienteRepositorio.clientePorCedulaNit(identificacion, nombre);
			
			if (null == cliente) {
				
				clienteRepositorio.save(Utilidades.adicionarCliente(clienteBean));
				
				return Utilidades.respuestaExitosa(informacionServicio);
				
			}else {
				
				return Utilidades.registroExistente(informacionServicio);
				
			}
			
			
		}catch (InvalidDataAccessResourceUsageException e) {
			System.err.println("[ClienteNegocio] ERROR JPA-Revise que en el esquema de BD exista la Tabla o en el entity (package:domain) del proyecto exista la propiedad schema ::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}catch (JpaObjectRetrievalFailureException e) {
			System.err.println("[ClienteNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		} catch (Exception e) {			
			System.err.println("[ClienteNegocio] ERROR::"+e);
			return Utilidades.errorRespuesta(informacionServicio);
		}
		
		
	}

	@Override
	public RespuestaDataList actualizarCliente(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = new InformacionServicio();
		
		ClienteBean clienteBean = solicitud.getSolicitudData().getCliente();
		int id = solicitud.getSolicitudData().getCliente().getId();
		
		Cliente cliente = clienteRepositorio.clientePorId(id);
		
		if(null != cliente) {
			
			Cliente clienteActualizar = Utilidades.actualizarCliente(cliente, clienteBean);
			clienteRepositorio.save(clienteActualizar);
			
			return Utilidades.respuestaExitosa(informacionServicio);
			
		}else {
			
			return Utilidades.sinResultado(informacionServicio);
			
		}
		
	}

	@Override
	public RespuestaDataList eliminarCliente(Solicitud solicitud) {
		
		InformacionServicio informacionServicio = new InformacionServicio();
		int id = solicitud.getSolicitudData().getCliente().getId();
		
		Cliente cliente = clienteRepositorio.clientePorId(id);
		
		if(null != cliente) {
			
			Cliente clienteFactura = clienteRepositorio.clienteFactura(cliente.getId());
			
			if(null != clienteFactura) {
				
				clienteRepositorio.delete(cliente);
				return Utilidades.respuestaExitosa(informacionServicio);
				
			}else {
				
				return Utilidades.registroExistente(informacionServicio);
				
			}
			
		}else {
			
			return Utilidades.sinResultado(informacionServicio);
			
		}
		
	}

}
