import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Plato } from '../models/plato';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
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

  apiURL : string = "http://10.5.3.10:8080/";

  constructor(private http: HttpClient) { }

  getPlatosByLocal(localId: string): Observable<any>{
    return this.http.get(this.apiURL+'locales/'+localId);
  }


    //return of(this.platos);
}
