import { Routes } from '@angular/router';
import { ListaClienteComponente } from './componentes/lista-cliente/lista-cliente.componente';
import { AdicionarClienteComponente } from './componentes/adicionar-cliente/adicionar-cliente.componente';
import { ActualizarClienteComponente } from './componentes/actualizar-cliente/actualizar-cliente.componente';
import { ListarFacturaComponente } from './componentes/listar-factura/listar-factura.componente';
import { AdicionarFacturaComponente } from './componentes/adicionar-factura/adicionar-factura.componente';
import { ListarPagoComponente } from './componentes/listar-pago/listar-pago.componente';
import { AdicionarPagoComponente } from './componentes/adicionar-pago/adicionar-pago.componente';
import { ClienteFacturaComponente } from './componentes/listar-clientefactura/listar-clientefactura.componente';
import { HistorialConsumoComponente } from './componentes/historial-consumo/historial-consumo.componente';
import { ConsultarFacturaNoPagaComponent } from './componentes/consultar-facturanopaga/consultar-facturanopaga.componente';

export const ROUTES: Routes = [
    { path: 'listar-cliente', component: ListaClienteComponente },
    { path: 'adicionar-cliente', component: AdicionarClienteComponente },
    { path: 'actualizar-cliente', component: ActualizarClienteComponente },
    { path: 'listar-factura', component: ListarFacturaComponente },
    { path: 'adicionar-factura', component: AdicionarFacturaComponente },
    { path: 'listar-pago', component: ListarPagoComponente },
    { path: 'adicionar-pago', component: AdicionarPagoComponente },
    { path: 'listar-clientefactura', component: ClienteFacturaComponente },
    { path: 'historial-consumo', component: HistorialConsumoComponente },
    { path: 'consultar-facturanopaga', component: ConsultarFacturaNoPagaComponent },
    { path: '', pathMatch: 'full', redirectTo: 'listar-cliente' },
    { path: '**', pathMatch: 'full', redirectTo: 'listar-cliente' }
];