import { Component, OnInit } from "@angular/core";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { FacturaBean } from "../../modelo/facturaBean";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "../../modelo/solicitud";
import { Router } from "@angular/router";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";

@Component({
    selector: 'app-consultar-facturanopaga',
    templateUrl: './consultar-facturanopaga.componente.html',
    styleUrls: ['./consultar-facturanopaga.componente.css']
  })
export class ConsultarFacturaNoPagaComponent implements OnInit{

  listaFactura:FacturaBean[] = [];
  estadoRespuesta:string;

  constructor(private ruta: Router, private servicio: FacturacionServicio){}

  ngOnInit(){



  }

  consultarFactura(numeroFactura:number){

    var informacionServicio = new InformacionServicio('consultar factura');
    var factura = new FacturaBean(0,numeroFactura,0,null,0,0,null,0);
    var solicitudData = new SolicitudData(null,factura,null);

    var solicitud = new Solicitud(solicitudData, informacionServicio);

    this.servicio.consultarFacturaNoPaga(solicitud).subscribe(

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
                        this.estadoRespuesta = "La factura no existe";
                    }else if(data.estadoRespuesta.codigoEstado == 205){
                      this.listaFactura = null;
                        this.estadoRespuesta = "La factura ya se encuentra pagada";
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