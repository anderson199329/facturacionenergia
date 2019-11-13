package com.co.facturacion.energia.aplicacion.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.facturacion.energia.aplicacion.dominio.Pago;

public interface PagoRepositorio extends CrudRepository<Pago, Long>{
	
	@Query("select p from Pago p")
	public List<Pago> encontrarPago();
	
	@Query("select p from Pago p where fkFactura.id = ?1")
	public Pago encontrarFacturaPaga(int factura);

}
