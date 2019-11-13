export class ClienteBean{

    id:number;
    cedulaNit:number;
    cliente:string;
    telefono:number;
    celular:number;
    estrato:number;

    constructor(id:number, cedulaNit:number, cliente:string, telefono:number, celular:number, estrato:number){

        this.id = id;
        this.cedulaNit = cedulaNit;
        this.cliente = cliente;
        this.telefono = telefono;
        this.celular = celular;
        this.estrato = estrato;

    }

}