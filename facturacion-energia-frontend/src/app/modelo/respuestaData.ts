import { ClienteBean } from "./clienteBean";
import { FacturaBean } from "./facturaBean";
import { PagoBean } from "./pagoBean";
import { ClienteFacturaBean } from "./clienteFacturaBean";

export class RespuestaData{

    cliente:Array<ClienteBean>;
    factura:Array<FacturaBean>;
    pago:Array<PagoBean>;
    clienteFactura:Array<ClienteFacturaBean>;

    constructor(cliente:Array<ClienteBean>, factura:Array<FacturaBean>, pago:Array<PagoBean>, clienteFactura:Array<ClienteFacturaBean>){

        this.cliente = cliente;
        this.factura = factura;
        this.pago = pago;
        this.clienteFactura = clienteFactura;

    }

}