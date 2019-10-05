import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Plato } from '../models/plato';

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

  constructor() { }

  getPlatos(){
    return of(this.platos);
  }

}
