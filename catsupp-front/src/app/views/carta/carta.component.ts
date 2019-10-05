import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/services/client-service';


import { ActivatedRoute, Router } from '@angular/router';
import { Local } from 'src/app/models/local';


@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {

  local: Local;

  constructor(private clientService: ClientService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    let localId = this.route.snapshot.params.local;
    this.local = {
      id:null,
      nombre:'',
      platos: []
      
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

  showPlatoDetails(id: number){
    this.router.navigate(['detalle', id,this.local.id])
  }

}
