export class ClienteFacturaBean{

    id:number;
    cedulaNit:number;
    cliente:string;
    telefono:number;
    celular:number;
    estrato:number;
    facturaPaga:Array<number>;
    facturaPendientePago:Array<number>;

    constructor(id:number, cedulaNit:number, cliente:string, telefono:number, celular:number, estrato:number, facturaPaga:Array<number>, facturaPendientePago:Array<number>){

        this.id = id;
        this.cedulaNit = cedulaNit;
        this.cliente = cliente;
        this.telefono = telefono;
        this.celular = celular;
        this.estrato = estrato;
        this.facturaPaga = facturaPaga;
        this.facturaPendientePago = facturaPendientePago;

    }

}