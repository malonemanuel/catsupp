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

 constructor(){}

 ngOnInit(){
   
 }


}
