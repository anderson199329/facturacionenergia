import { OnInit, Component } from "@angular/core";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { ClienteBean } from "../../modelo/clienteBean";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "../../modelo/solicitud";
import { Router } from "@angular/router";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { DetalleCliente } from "../actualizar-cliente/actualizar-cliente.detalle";
import Swal from 'sweetalert2';

@Component({
    selector: 'app-lista-cliente',
    templateUrl: './lista-cliente.componente.html',
    styleUrls: ['./lista-cliente.componente.css']
  })
export class ListaClienteComponente implements OnInit{

  listaCliente:ClienteBean[] = [];
  estadoRespuesta:string;

    constructor(private ruta: Router, private servicio: FacturacionServicio, private detalleCliente:DetalleCliente){

    }

    ngOnInit(){

      var informacionServicio = new InformacionServicio('consultar cliente');
      var cliente = new ClienteBean(0,0,null,0,0,0);
      var solicitudData = new SolicitudData(cliente,null,null);

      var solicitud = new Solicitud(solicitudData, informacionServicio);

      this.servicio.consultarCliente(solicitud).subscribe(

        data => {

          console.log(data);
                  if(data.estadoRespuesta.codigoRespuesta == 200){
                      if(data.estadoRespuesta.codigoEstado == 0){
                          this.listaCliente = data.respuestaData.cliente;
                          
                      }else if(data.estadoRespuesta.codigoEstado == 403){
                          this.listaCliente = null;
                          this.estadoRespuesta = "Se presento un error en el sistema";
                      }else if(data.estadoRespuesta.codigoEstado == 204){
                        this.listaCliente = null;
                          this.estadoRespuesta = "No existen clientes creados";
                      }

                    }else{
                      this.listaCliente = null;
                      this.estadoRespuesta = "Se presento un error de comunicación";
                  }

         },
         error => {
          console.log(<any>error);
          if(error.status == 400){
            this.listaCliente = null;
              this.estadoRespuesta = "Se presento un error en el sistema";
          }else{
            this.listaCliente = null;
              this.estadoRespuesta = "Se presento un error de comunicación";
          }
          
          }

      );

  }

  adicionarCliente(){
    this.ruta.navigate(['adicionar-cliente']);
  }

  actualizarCliente(cliente:ClienteBean):void{
    this.detalleCliente.setDetalleCliente(cliente);
    this.ruta.navigate(['actualizar-cliente']);
  }

  historialConsumo(cliente:ClienteBean){
    this.detalleCliente.setDetalleCliente(cliente);
    this.ruta.navigate(['historial-consumo']);
  }

  eliminarCliente(cliente:ClienteBean):void{

      var cliente = new ClienteBean(cliente.id,0,null,0,0,0);
      var informacionServicio = new InformacionServicio('Eliminar cliente');
      var solicitudData = new SolicitudData(cliente,null,null);

      var solicitud = new Solicitud(solicitudData, informacionServicio);

      this.servicio.eliminarCliente(solicitud).subscribe(
        data =>{

          if(data.estadoRespuesta.codigoRespuesta == 200){
            if(data.estadoRespuesta.codigoEstado == 0){
                console.log('Se eliminó exitosamente el cliente');
                this.ngOnInit();
            }else if(data.estadoRespuesta.codigoEstado == 500){
                console.log('Se presento un error en el sistema');
            }
            else if(data.estadoRespuesta.codigoEstado == 204){
                console.log('el cliente no existe');
            }else if(data.estadoRespuesta.codigoEstado == 205){
              Swal.fire('Error', 'el cliente tiene facturas asociadas', 'error');
          }
             
        }else{
            console.log('Se presento un error de comunicación');
        }
  
        }
      );


  }

}