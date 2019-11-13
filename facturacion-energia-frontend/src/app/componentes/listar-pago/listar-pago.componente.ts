import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { PagoBean } from "../../modelo/pagoBean";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "src/app/modelo/solicitud";

@Component({
    selector: 'app-listar-pago',
    templateUrl: './listar-pago.componente.html',
    styleUrls: ['./listar-pago.componente.css']
  })
export class ListarPagoComponente implements OnInit{

  listaPago:PagoBean[] = [];
  estadoRespuesta:string;

  constructor(private ruta: Router, private servicio: FacturacionServicio){}

  ngOnInit(){

    var informacionServicio = new InformacionServicio('consultar pago');
    var pago = new PagoBean(0,0,null,0);
    var solicitudData = new SolicitudData(null,null,pago);

    var solicitud = new Solicitud(solicitudData, informacionServicio);

    this.servicio.consultarPago(solicitud).subscribe(

      data => {

        console.log(data);
                if(data.estadoRespuesta.codigoRespuesta == 200){
                    if(data.estadoRespuesta.codigoEstado == 0){
                        this.listaPago = data.respuestaData.pago;
                        
                    }else if(data.estadoRespuesta.codigoEstado == 403){
                        this.listaPago = null;
                        this.estadoRespuesta = "Se presento un error en el sistema";
                    }else if(data.estadoRespuesta.codigoEstado == 204){
                      this.listaPago = null;
                        this.estadoRespuesta = "No existen pagos realizados";
                    }

                  }else{
                    this.listaPago = null;
                    this.estadoRespuesta = "Se presento un error de comunicación";
                }

       },
       error => {
        console.log(<any>error);
            if(error.status == 400){
                this.listaPago = null;
                this.estadoRespuesta = "Se presento un error en el sistema";
            }else{
                this.listaPago = null;
                this.estadoRespuesta = "Se presento un error de comunicación";
            }
        }

    );

  }

  realizarPago(){

    this.ruta.navigate(['adicionar-pago']);

  }

}