export class PagoBean{

    id:number;
    numeroFactura:number;
    fechaPago:Date;
    idFactura:number;

    constructor(id:number, numeroFactura:number, fechaPago:Date, idFactura:number){

        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fechaPago = fechaPago;
        this.idFactura = idFactura;

    }

}