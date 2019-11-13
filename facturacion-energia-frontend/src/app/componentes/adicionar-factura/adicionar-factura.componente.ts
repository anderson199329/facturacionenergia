import { OnInit, Component } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { FacturacionServicio } from "../../servicio/facturacion.servicio";
import { Router } from "@angular/router";
import { ClienteBean } from "../../modelo/clienteBean";
import { InformacionServicio } from "../../modelo/informacionServicio";
import { SolicitudData } from "../../modelo/solicitudData";
import { Solicitud } from "../../modelo/solicitud";
import { FacturaBean } from "../../modelo/facturaBean";
import Swal from 'sweetalert2';

@Component({
    selector: 'app-adicionar-factura',
    templateUrl: './adicionar-factura.componente.html',
    styleUrls: ['./adicionar-factura.componente.css']
  })
export class AdicionarFacturaComponente implements OnInit{

    addForm : FormGroup;
    cliente: ClienteBean;
    listaMeses:string[]=["ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"];
    listaAno:number[]=[2017,2018,2019];
    listaCliente:ClienteBean[] = [];

    constructor(private formBuilder: FormBuilder, private servicio:FacturacionServicio, private ruta:Router){}

    ngOnInit(){

      var informacionServicio = new InformacionServicio('consultar cliente');
      var cliente = new ClienteBean(0,0,null,0,0,0);
      var solicitudData = new SolicitudData(cliente,null,null);

      var solicitud = new Solicitud(solicitudData, informacionServicio);

        this.servicio.consultarCliente(solicitud).subscribe(
            data =>{

                this.listaCliente = data.respuestaData.cliente;
            }
        );

        this.addForm = this.formBuilder.group({
            numero: ['',Validators.required],
            consumo: ['',Validators.required],
            mes: ['',Validators.required],
            ano: ['',Validators.required],
            totalPagar: ['',Validators.required],
            cliente: ['',Validators.required]
        });

    }

    onSubmit(){

        if (this.addForm.invalid) {
            return;
      
        }

        var valueForm = this.addForm.value;
        var factura = new FacturaBean(0,valueForm.numero,valueForm.consumo,valueForm.mes,valueForm.ano,valueForm.totalPagar,null,valueForm.cliente);
        var informacionServicio = new InformacionServicio('Adicionar factura');
        var solicitudData = new SolicitudData(null,factura,null);
        var solicitud = new Solicitud(solicitudData, informacionServicio);

        this.servicio.adicionarFactura(solicitud).subscribe(

            data =>{

                if(data.estadoRespuesta.codigoRespuesta == 200){
                  if(data.estadoRespuesta.codigoEstado == 0){
                      console.log('Se agregó exitosamente la factura');
                      this.ruta.navigate(['listar-factura']);
                  }else if(data.estadoRespuesta.codigoEstado == 500){
                      console.log('Se presento un error en el sistema');
                  }
                  else if(data.estadoRespuesta.codigoEstado == 205){
                    Swal.fire('Error', 'la factura ya se encuentra registrada', 'error');
                  }else if(data.estadoRespuesta.codigoEstado == 203){
                    Swal.fire('Error', 'El usuario seleccionado ya tiene registrada una factura del mes de '+valueForm.mes+' del año '+valueForm.ano+'', 'error');
                  }
                   
              }else{
                  console.log('Se presento un error de comunicación');
              }
        
            }

        );

    }

    listarFactura(){

        this.ruta.navigate(['listar-factura']);

    }

}