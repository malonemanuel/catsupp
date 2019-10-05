import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ScanCodeComponent } from './views/scan-code/scan-code.component';

import { BusquedaComponent } from './views/busqueda/busqueda.component';
import { CartaComponent } from './views/carta/carta.component';


const routes: Routes = [
  { path: '**', component: CartaComponent },
  { 
    path: 'scan-code', 
    component: ScanCodeComponent 
  },  
  { 
    path: 'busqueda', 
    component: BusquedaComponent 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
