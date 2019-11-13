import { ClienteBean } from "./clienteBean";
import { FacturaBean } from "./facturaBean";
import { PagoBean } from "./pagoBean";

export class SolicitudData{

    cliente:ClienteBean;
    factura:FacturaBean;
    pago:PagoBean;

    constructor(cliente:ClienteBean, factura:FacturaBean, pago:PagoBean){

        this.cliente = cliente;
        this.factura = factura;
        this.pago = pago;

    }

}