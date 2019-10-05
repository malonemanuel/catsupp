import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from 'src/app/services/client-service';
import { Plato } from 'src/app/models/plato';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  platoId: number;
  localId: number;
  detallePlato: Plato;

  constructor(private router: ActivatedRoute, private clientService: ClientService) {
    this.platoId = this.router.snapshot.params.platoId;
    this.localId = this.router.snapshot.params.localId;
   }

  ngOnInit() {
    this.clientService.getPlatoDetalleById(this.localId, this.platoId)
      .subscribe( data => {
        this.detallePlato = data;
      })
  }

}
