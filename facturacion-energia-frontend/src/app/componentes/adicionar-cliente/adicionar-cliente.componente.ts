import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ClienteBean } from "../../modelo/clienteBean";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "../../modelo/solicitud";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { Router } from "@angular/router";
import Swal from 'sweetalert2';

@Component({
    selector: 'app-adicionar-cliente',
    templateUrl: './adicionar-cliente.componente.html',
    styleUrls: ['./adicionar-cliente.componente.css']
  })
export class AdicionarClienteComponente implements OnInit{

  addForm : FormGroup;

  constructor(private formBuilder: FormBuilder, private servicio:FacturacionServicio, private ruta:Router){

  }

  ngOnInit(){

    this.addForm = this.formBuilder.group({

      cedulaNit: ['',Validators.required],
      cliente: ['',Validators.required],
      estrato: ['',Validators.required],
      telefono: [''],
      celular: ['']

    });

  }

  onSubmit(){

    if (this.addForm.invalid) {
      return;

    }

    var valueForm = this.addForm.value;
    var cliente = new ClienteBean(0,valueForm.cedulaNit,valueForm.cliente,valueForm.telefono,valueForm.celular,valueForm.estrato);
    var informacionServicio = new InformacionServicio('Adicionar cliente');
    var solicitudData = new SolicitudData(cliente,null,null);
    var solicitud = new Solicitud(solicitudData, informacionServicio);

    this.servicio.adicionarCliente(solicitud).subscribe(

      data =>{

        if(data.estadoRespuesta.codigoRespuesta == 200){
          if(data.estadoRespuesta.codigoEstado == 0){
              console.log('Se agregó exitosamente el cliente');
              this.ruta.navigate(['lista-cliente']);
          }else if(data.estadoRespuesta.codigoEstado == 500){
              console.log('Se presento un error en el sistema');
          }
          else if(data.estadoRespuesta.codigoEstado == 205){
            Swal.fire('Error', 'el cliente ya se encuentra registrado', 'error');
          }
           
      }else{
          console.log('Se presento un error de comunicación');
      }

      }

    );

  }

}