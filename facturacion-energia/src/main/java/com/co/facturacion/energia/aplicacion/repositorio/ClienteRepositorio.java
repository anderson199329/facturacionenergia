package com.co.facturacion.energia.aplicacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.facturacion.energia.aplicacion.dominio.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long>{
	
	@Query("select c From Cliente c")
	public List<Cliente> encontrarCliente();
	
	@Query("select c From Cliente c where cedulaNit = ?1 and cliente = ?2")
	public Cliente clientePorCedulaNit(long identificacion, String nombre);
	
	@Query("select c From Cliente c where id = ?1")
	public Cliente clientePorId(int id);
	
	@Query("select c From Cliente c where id = ?1 and id not in (select fkCliente.id from Factura)")
	public Cliente clienteFactura(int id);

}
