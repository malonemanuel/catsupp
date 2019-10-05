import { Component, OnInit } from '@angular/core';
import { Plato } from 'src/app/models/plato';
import { ClientService } from 'src/app/services/client-service';

@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {

  platos: Plato[];

  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.clientService.getPlatos()
      .subscribe( data => {
        this.platos = data;
      })
  }

  showPlatoDetails(){
    console.log("Plato detalles");
  }

}
