package com.co.facturacion.energia.aplicacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.facturacion.energia.aplicacion.dominio.Factura;

public interface FacturaRepositorio extends CrudRepository<Factura, Long>{
	
	@Query("select f From Factura f ")
	public List<Factura> encontrarFactura();
	
	@Query("select f From Factura f where numero = ?1")
	public Factura encontrarNumero(long numero);
	
	@Query("select f From Factura f where id not in (select fkFactura.id From Pago)")
	public List<Factura> encontrarFacturaPendiente();
	
	@Query("select f From Factura f where fkCliente.id = ?1 and id not in (select fkFactura.id From Pago)")
	public List<Factura> encontrarFacturaPendienteUsuario(int id);
	
	@Query("select f From Factura f where fkCliente.id = ?1 and id in (select fkFactura.id From Pago)")
	public List<Factura> facturaPagaUsuario(int id);
	
	@Query("select f From Factura f where fkCliente.id = ?1")
	public List<Factura> historialConsumo(int cliente);
	
	@Query("select f From Factura f where fkCliente.id = ?1 and mes = ?2 and ano = ?3")
	public Factura facturaUsuarioMesAno(int usuario, String mes, int ano);

}
