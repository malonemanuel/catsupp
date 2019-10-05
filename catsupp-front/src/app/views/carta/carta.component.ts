import { Component, OnInit } from '@angular/core';
import { Plato } from 'src/app/models/plato';
import { ClientService } from 'src/app/services/client-service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {

  platos: Plato[];

  constructor(private clientService: ClientService, private router: ActivatedRoute, private route: Router) { }

  ngOnInit() {
    let localId = this.router.snapshot.params.local;
    this.clientService.getPlatosByLocal()
      .subscribe( data => {
        this.platos = data;
      })
  }

  showPlatoDetails(id: number){
    this.route.navigate(['detalle', id])
  }

}
