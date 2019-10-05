import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Local } from 'src/app/models/local';
import { FormControl } from '@angular/forms';
import { ClientService } from 'src/app/services/client-service';
import { Router } from '@angular/router';
import { startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-busqueda-local',
  templateUrl: './busqueda-local.component.html',
  styleUrls: ['./busqueda-local.component.css']
})
export class BusquedaLocalComponent implements OnInit {

  private locales:Observable<Local[]>

  private busqueda:FormControl;

  constructor(
    private client:ClientService,
    private route:Router
  ) {
    this.busqueda=new FormControl();
  }

  ngOnInit() {
    
    this.locales = this.busqueda.valueChanges
      .pipe(
        startWith(''),
        switchMap( value => this.client.findLocales(value) )
      );
      
  }

  mostrarCartaDelLocal(){
    console.log(this.busqueda.value)
    let result:Local = this.busqueda.value;
    this.route.navigate(['carta',result.id ])
  }

  mostrarNombre(local:Local){
    return local && local.nombre;
  }

}
