import { Component, OnInit } from "@angular/core";
import { ClienteFacturaBean } from "../../modelo/clienteFacturaBean";
import { Router } from "@angular/router";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { Solicitud } from "../../modelo/solicitud";

@Component({
    selector: 'app-listar-clientefactura',
    templateUrl: './listar-clientefactura.componente.html',
    styleUrls: ['./listar-clientefactura.componente.css']
  })
export class ClienteFacturaComponente implements OnInit{

    listaClienteFactura:ClienteFacturaBean[] = [];

    constructor(private ruta: Router, private servicio: FacturacionServicio){}

    ngOnInit(){

        var informacionServicio = new InformacionServicio('consultar factura');

        var solicitud = new Solicitud(null, informacionServicio);

        this.servicio.clienteFactura(solicitud).subscribe(

            data => {
            
                this.listaClienteFactura = data.respuestaData.clienteFactura;
              
               }

        );

    }

}