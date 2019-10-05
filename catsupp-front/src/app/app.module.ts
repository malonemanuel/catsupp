import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { CustomMaterialModule } from './modules/custom-material/custom-material.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './views/home/home.component';
import { CartaComponent } from './views/carta/carta.component';
import { ScanCodeComponent } from './views/scan-code/scan-code.component';
import { ZXingScannerModule } from '@zxing/ngx-scanner';
import { BusquedaComponent } from './views/busqueda/busqueda.component';
import {HttpClientModule} from '@angular/common/http';
import { DetalleComponent } from './views/detalle/detalle.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CartaComponent,
    ScanCodeComponent,
    BusquedaComponent,
    DetalleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    ZXingScannerModule,
    HttpClientModule
  ],
  exports: [
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
