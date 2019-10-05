import { Component, OnInit } from '@angular/core';
import { Plato } from 'src/app/models/plato';
import { ClientService } from 'src/app/services/client-service';
import { RouterOutlet, ActivatedRoute } from '@angular/router';
import { Local } from 'src/app/models/local';

@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {

  local: Local;

  constructor(private clientService: ClientService, private route: ActivatedRoute) { }

  ngOnInit() {
    let localId = this.route.snapshot.params.local;
    this.local = {
      id:null,
      nombre:'',
      platos:[]
      
    };
    this.clientService.getPlatosByLocal(localId)
      .subscribe( 
        data => {
          this.local = data;
          console.log(this.local);
        },
        error => {
          console.log(error);
        }
      )

  }

  showPlatoDetails(){
    console.log("Plato detalles");
  }

}
