import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Plato } from '../models/plato';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  platos: Plato[];

  constructor() { }

  getPlatos(){
    return of(this.platos);
  }

}
