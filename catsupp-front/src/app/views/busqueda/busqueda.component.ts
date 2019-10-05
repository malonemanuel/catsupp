import { Component, OnInit } from '@angular/core';
import { Local } from 'src/app/models/local';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { startWith,map, switchMap } from 'rxjs/operators';
import { ClientService } from 'src/app/services/client-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  private locales:Observable<Local[]>

  private busqueda:FormControl;

  constructor(
    private client:ClientService,
    private route:Router
  ) {
    this.busqueda=new FormControl();
  }

  ngOnInit() {

    let locales = [
      {
        id:'mc-donalds',
        nombre: 'Mc Donalds'
      },
      {
        id:'burger-king',
        nombre: 'Burger King'
      },
      {
        id:'wendys',
        nombre: 'Wendy\'s'
      }
    ]

    
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
    return local.nombre;
  }

}
