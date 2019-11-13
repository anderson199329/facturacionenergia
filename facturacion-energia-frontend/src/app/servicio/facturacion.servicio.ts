import { environment } from "../../environments/environment";
import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Solicitud } from "../modelo/solicitud";
import { Observable } from "rxjs";
import { RespuestaDataList } from "../modelo/respuestaDataList";

const baseUrl = environment.baseUrl;

@Injectable({
  providedIn: 'root'
})

export class FacturacionServicio{

    private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor( private http: HttpClient ) {
    console.log('Servicio iniciado');
  }

  consultarCliente(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/cliente/consultar", solicitud, {headers: this.httpHeaders});
  }

  adicionarCliente(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/cliente/adicionar", solicitud, {headers: this.httpHeaders});
  }

  actualizarCliente(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/cliente/actualizar", solicitud, {headers: this.httpHeaders});
  }

  eliminarCliente(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/cliente/eliminar", solicitud, {headers: this.httpHeaders});
  }

  consultarFactura(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/factura/consultar", solicitud, {headers: this.httpHeaders});
  }

   adicionarFactura(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/factura/adicionar", solicitud, {headers: this.httpHeaders});
  }

  consultarPago(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/pago/consultar", solicitud, {headers: this.httpHeaders});
  }

  listarFacturaPendiente(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/pago/listarFactura", solicitud, {headers: this.httpHeaders});
  }

  adicionarPago(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/pago/adicionar", solicitud, {headers: this.httpHeaders});
  }

  clienteFactura(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/informe/clienteFactura", solicitud, {headers: this.httpHeaders});
  }

  historialConsumo(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/informe/historialConsumo", solicitud, {headers: this.httpHeaders});
  }

  consultarFacturaNoPaga(solicitud:Solicitud): Observable<RespuestaDataList> {
    return this.http.post<RespuestaDataList>(baseUrl+"facturacion/informe/consultarPagoFactura", solicitud, {headers: this.httpHeaders});
  }

}