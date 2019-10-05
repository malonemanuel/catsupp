import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ScanCodeComponent } from './views/scan-code/scan-code.component';
import { BusquedaComponent } from './views/busqueda/busqueda.component';


const routes: Routes = [
  
  { 
    path: 'scan-code', 
    component: ScanCodeComponent 
  },  
  { 
    path: 'busqueda', 
    component: BusquedaComponent 
  },  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
