import { Injectable } from "@angular/core";
import { ClienteBean } from "../../modelo/clienteBean";

@Injectable({
    providedIn: 'root'
  })
export class DetalleCliente{

    private detalleCliente:ClienteBean;

    constructor(){}

    public setDetalleCliente(detalleCliente:ClienteBean){
        this.detalleCliente = detalleCliente;
    }

    public getDetalleCliente(){
        return this.detalleCliente;
    }

}