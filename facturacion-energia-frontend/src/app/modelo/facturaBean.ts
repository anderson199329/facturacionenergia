export class FacturaBean{

    id:number;
    numero:number;
    consumo:number;
    mes:string;
    ano:number;
    totalPagar:number;
    cliente:string;
    idCliente:number;

    constructor(id:number, numero:number, consumo:number, mes:string, ano:number, totalPagar:number, cliente:string, idCliente:number){

        this.id = id;
        this.numero = numero;
        this.consumo = consumo;
        this.mes = mes;
        this.ano = ano;
        this.totalPagar = totalPagar;
        this.cliente = cliente;
        this.idCliente = idCliente;

    }

}