import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ScanCodeComponent } from './views/scan-code/scan-code.component';

import { BusquedaComponent } from './views/busqueda/busqueda.component';
import { CartaComponent } from './views/carta/carta.component';
import { HomeComponent } from './views/home/home.component';
import { DetalleComponent } from './views/detalle/detalle.component';


const routes: Routes = [
  { 
    path: 'home', 
    component: HomeComponent 
  },
  { 
    path: 'carta/:local', 
    component: CartaComponent
  },
  { 
    path: 'scan-code', 
    component: ScanCodeComponent 
  },  
  { 
    path: 'busqueda', 
    component: BusquedaComponent 
  },
  { 
    path: 'detalle/:platoId', 
    component: DetalleComponent
  },
  { 
    path: '**', 
    component: HomeComponent 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
