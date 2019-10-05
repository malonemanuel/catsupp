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
      id: 1,
      nombre: 'Wok de Vegetales',
      descripcion: 'Salteado de verduras',
      imagen: 'assets/img/plato/wokvegetales.jpg',
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

  getPlatosByLocal(){
    return of(this.platos);
  }
  

  findLocales(local:string){
    return this.http.get<Local[]>("http://localhost:8080/locales",{ params : { q: local }});
  }

}
