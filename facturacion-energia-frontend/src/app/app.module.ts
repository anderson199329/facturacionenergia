import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ROUTES } from './app.routes';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { ListaClienteComponente } from './componentes/lista-cliente/lista-cliente.componente';
import { AdicionarClienteComponente } from './componentes/adicionar-cliente/adicionar-cliente.componente';
import { OnlynumberDirective } from './componentes/onlynumber/onlynumber.component';
import { ActualizarClienteComponente } from './componentes/actualizar-cliente/actualizar-cliente.componente';
import { ListarFacturaComponente } from './componentes/listar-factura/listar-factura.componente';
import { AdicionarFacturaComponente } from './componentes/adicionar-factura/adicionar-factura.componente';
import { ListarPagoComponente } from './componentes/listar-pago/listar-pago.componente';
import { AdicionarPagoComponente } from './componentes/adicionar-pago/adicionar-pago.componente';
import { ClienteFacturaComponente } from './componentes/listar-clientefactura/listar-clientefactura.componente';
import { HistorialConsumoComponente } from './componentes/historial-consumo/historial-consumo.componente';
import { ConsultarFacturaNoPagaComponent } from './componentes/consultar-facturanopaga/consultar-facturanopaga.componente';

@NgModule({
  declarations: [
    AppComponent,
    ListaClienteComponente,
    AdicionarClienteComponente,
    ActualizarClienteComponente,
    ListarFacturaComponente,
    AdicionarFacturaComponente,
    ListarPagoComponente,
    AdicionarPagoComponente,
    ClienteFacturaComponente,
    HistorialConsumoComponente,
    ConsultarFacturaNoPagaComponent,
    OnlynumberDirective
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot( ROUTES, { useHash: true } ),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
