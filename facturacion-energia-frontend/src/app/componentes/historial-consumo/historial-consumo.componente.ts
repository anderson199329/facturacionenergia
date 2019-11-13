import { Component, OnInit } from "@angular/core";
import { FormBuilder } from "@angular/forms";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { Router } from "@angular/router";
import { FacturaBean } from "../../modelo/facturaBean";
import { DetalleCliente } from "../actualizar-cliente/actualizar-cliente.detalle";
import { ClienteBean } from "../../modelo/clienteBean";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "../../modelo/solicitud";

@Component({
    selector: 'app-historial-consumo',
    templateUrl: './historial-consumo.componente.html',
    styleUrls: ['./historial-consumo.componente.css']
  })
export class HistorialConsumoComponente implements OnInit{

    listaFactura:FacturaBean[] = [];
    estadoRespuesta:string;
    cliente:ClienteBean;

    constructor(private formBuilder: FormBuilder, private servicio:FacturacionServicio, private ruta:Router, private detalleCliente:DetalleCliente){}

    ngOnInit(){

        this.cliente = this.detalleCliente.getDetalleCliente();

        if(this.cliente == null){
            this.ruta.navigate(['listar-clientes'])
        }

        var informacionServicio = new InformacionServicio('consultar cliente');
        var cliente = new ClienteBean(this.cliente.id,0,null,0,0,0);
        var solicitudData = new SolicitudData(cliente,null,null);

        var solicitud = new Solicitud(solicitudData, informacionServicio);

        this.servicio.historialConsumo(solicitud).subscribe(

            data => {

                console.log(data);
                        if(data.estadoRespuesta.codigoRespuesta == 200){
                            if(data.estadoRespuesta.codigoEstado == 0){
                                this.listaFactura = data.respuestaData.factura;
                                
                            }else if(data.estadoRespuesta.codigoEstado == 403){
                                this.listaFactura = null;
                                this.estadoRespuesta = "Se presento un error en el sistema";
                            }else if(data.estadoRespuesta.codigoEstado == 204){
                              this.listaFactura = null;
                                this.estadoRespuesta = "Sin resultado";
                            }
      
                          }else{
                            this.listaFactura = null;
                            this.estadoRespuesta = "Se presento un error de comunicación";
                        }
      
               },
               error => {
                console.log(<any>error);
                if(error.status == 400){
                  this.listaFactura = null;
                    this.estadoRespuesta = "Se presento un error en el sistema";
                }else{
                  this.listaFactura = null;
                    this.estadoRespuesta = "Se presento un error de comunicación";
                }
                
                }

        );

    }

}