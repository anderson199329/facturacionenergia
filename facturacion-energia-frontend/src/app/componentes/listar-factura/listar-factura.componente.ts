import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { FacturaBean } from "../../modelo/facturaBean";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "../../modelo/solicitud";

@Component({
    selector: 'app-listar-factura',
    templateUrl: './listar-factura.componente.html',
    styleUrls: ['./listar-factura.componente.css']
  })
export class ListarFacturaComponente implements OnInit{

    listaFactura:FacturaBean[] = [];
    estadoRespuesta:string;

    constructor(private ruta: Router, private servicio: FacturacionServicio){}

    ngOnInit(){

        var informacionServicio = new InformacionServicio('consultar factura');
        var factura = new FacturaBean(0,0,0,null,0,0,null,0);
        var solicitudData = new SolicitudData(null,factura,null);

        var solicitud = new Solicitud(solicitudData, informacionServicio);

        this.servicio.consultarFactura(solicitud).subscribe(

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
                                this.estadoRespuesta = "No existen facturas creadas";
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

    adicionarFactura(){
        this.ruta.navigate(['adicionar-factura']);
    }

}