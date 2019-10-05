import { Component, OnInit } from '@angular/core';
import { Local } from 'src/app/models/local';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  private locales:Local[]

  constructor(

  ) {

  }

  ngOnInit() {
  }

}
