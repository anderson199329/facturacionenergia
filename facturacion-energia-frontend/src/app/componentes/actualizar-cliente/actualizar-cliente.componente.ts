import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ClienteBean } from "../../modelo/clienteBean";
import { Router } from "@angular/router";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { DetalleCliente } from "./actualizar-cliente.detalle";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "src/app/modelo/solicitud";

@Component({
    selector: 'app-actualizar-cliente',
    templateUrl: './actualizar-cliente.componente.html',
    styleUrls: ['./actualizar-cliente.componente.css']
  })
export class ActualizarClienteComponente implements OnInit{

  editForm: FormGroup;
  actualizarCliente:ClienteBean;

  constructor(private formBuilder: FormBuilder, private ruta: Router, private servicio:FacturacionServicio, private detalleCliente:DetalleCliente){

  }

  ngOnInit(){

    this.actualizarCliente = this.detalleCliente.getDetalleCliente();

    if(this.actualizarCliente == null){
      this.ruta.navigate(['listar-clientes'])
    }

    this.editForm = this.formBuilder.group({
      estrato:  [this.actualizarCliente!=null?this.actualizarCliente.estrato:'',Validators.required],
      telefono: [this.actualizarCliente!=null?this.actualizarCliente.telefono:''],
      celular: [this.actualizarCliente!=null?this.actualizarCliente.celular:'']
    });

  }

  onSubmit(){

    if (this.editForm.invalid==true) {
      return;
    }

    var valueForm = this.editForm.value;
    var cliente = new ClienteBean(this.actualizarCliente.id,this.actualizarCliente.cedulaNit,this.actualizarCliente.cliente,valueForm.telefono,valueForm.celular,valueForm.estrato);
    var informacionServicio = new InformacionServicio('Actualizar cliente');

    var solicitudData = new SolicitudData(cliente,null,null);
    var solicitud = new Solicitud(solicitudData, informacionServicio);

    this.servicio.actualizarCliente(solicitud).subscribe(
      data =>{

        if(data.estadoRespuesta.codigoRespuesta == 200){
          if(data.estadoRespuesta.codigoEstado == 0){
              console.log('Se actualizó exitosamente el cliente');
              this.ruta.navigate(['lista-cliente']);
          }else if(data.estadoRespuesta.codigoEstado == 500){
              console.log('Se presento un error en el sistema');
          }
          else if(data.estadoRespuesta.codigoEstado == 204){
              console.log('el cliente no existe');
          }
           
      }else{
          console.log('Se presento un error de comunicación');
      }

      }
    );

  }

}