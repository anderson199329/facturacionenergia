import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { Router } from "@angular/router";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { FacturaBean } from "../../modelo/facturaBean";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "../../modelo/solicitud";
import { PagoBean } from "src/app/modelo/pagoBean";

@Component({
    selector: 'app-adicionar-pago',
    templateUrl: './adicionar-pago.componente.html',
    styleUrls: ['./adicionar-pago.componente.css']
  })
export class AdicionarPagoComponente implements OnInit{

  addForm : FormGroup;
  listaFactura:FacturaBean [] = [];

  constructor(private formBuilder: FormBuilder, private servicio:FacturacionServicio, private ruta:Router){}

  ngOnInit(){

    var informacionServicio = new InformacionServicio('consultar factura');
    var factura = new FacturaBean(0,0,0,null,0,0,null,0);
    var solicitudData = new SolicitudData(null,factura,null);

    var solicitud = new Solicitud(solicitudData,informacionServicio);

    this.servicio.listarFacturaPendiente(solicitud).subscribe(

      data =>{

        this.listaFactura = data.respuestaData.factura;

      }

    );

    this.addForm = this.formBuilder.group({
      numero: ['',Validators.required]
    });

  }

  onSubmit(){

    if (this.addForm.invalid) {
      return;

    }

    var valueForm = this.addForm.value;
    var pago = new PagoBean(0,0,null,valueForm.numero);
    var informacionServicio = new InformacionServicio('Adicionar pago');
    var solicitudData = new SolicitudData(null,null,pago);
    var solicitud = new Solicitud(solicitudData, informacionServicio);

    this.servicio.adicionarPago(solicitud).subscribe(

      data =>{

        if(data.estadoRespuesta.codigoRespuesta == 200){ 
          if(data.estadoRespuesta.codigoEstado == 0){
              console.log('Se agregó exitosamente el pago');
              this.ruta.navigate(['listar-pago']);
          }else if(data.estadoRespuesta.codigoEstado == 500){
              console.log('Se presento un error en el sistema');
          }
          else if(data.estadoRespuesta.codigoEstado == 205){
              console.log('El pago ya se encuentra registrado');
          }
           
        }else{
          console.log('Se presento un error de comunicación');
        }

      }

    );

  }

  listarPago(){

    this.ruta.navigate(['listar-pago']);

  }

}