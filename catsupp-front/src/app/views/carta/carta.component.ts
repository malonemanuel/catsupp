import { Component, OnInit } from '@angular/core';
import { Plato } from 'src/app/models/plato';
import { ClientService } from 'src/app/services/client-service';
<<<<<<< HEAD
import { RouterOutlet, ActivatedRoute } from '@angular/router';
import { Local } from 'src/app/models/local';
=======
import { ActivatedRoute, Router } from '@angular/router';
>>>>>>> 38706fcfda566d28d39df8314de76cb6aecc3835

@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {

  local: Local;

  constructor(private clientService: ClientService, private router: ActivatedRoute, private route: Router) { }

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

  showPlatoDetails(id: number){
    this.route.navigate(['detalle', id])
  }

}
