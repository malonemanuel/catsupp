import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Plato } from '../models/plato';
import { HttpClient } from '@angular/common/http';
import { Local } from '../models/local';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  platos: Plato[] = [
    {
      nombre: 'Wok de Vegetales',
      descripcion: 'Salteado de verduras',
      imagen: 'assets/img/plato/wokvegetales.jpg',
      precio: 50.50,
      ingredientes: [
        {
          nombre: 'Zanahoria',
          imagen: 'assets/img/ingrediente/zanahoria.jpg'
        },
        {
          nombre: 'Cebolla',
          imagen: 'assets/img/ingrediente/cebolla.jpg'
        }
      ]
    }
  ];

  constructor(
    private http:HttpClient
  ) { }

  getPlatos(){
    return of(this.platos);
  }

  findLocales(local:string){
    return this.http.get<Local[]>("http://localhost:8080/locales",{ params : { q: local }});
  }

}
