import { Injectable } from '@angular/core';
import { of, Observable } from 'rxjs';
import { Plato } from '../models/plato';

import { HttpClient } from '@angular/common/http';

import { retry, catchError } from 'rxjs/operators';

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
          imagen: 'assets/img/ingrediente/zanahoria.png'
        },
        {
          nombre: 'Cebolla',
          imagen: 'assets/img/ingrediente/cebolla.jpg'
        }
      ]
    }
  ];

  apiURL : string = "https://192.168.43.231:8443/";


  constructor(private http: HttpClient) { }

  getPlatosByLocal(localId: string): Observable<any>{
    return this.http.get(this.apiURL+'locales/'+localId);
  }


  findLocales(local:string):Observable<Local[]>{
    return this.http.get<Local[]>(this.apiURL+"locales",{ params : { q: local }});
  }


  getPlatoDetalleById(localId: number, platoId: number): Observable<any>{
    return this.http.get<Plato>(this.apiURL + 'locales/' + localId + '/platos/' + platoId);
  }

  /*
  getPlatoDetalleById(id:number): Observable<any>{
    return of(this.platos[0]);
  }
  */
}
