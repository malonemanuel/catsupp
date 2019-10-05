import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  platoId: number;

  constructor(private router: ActivatedRoute) {
    this.platoId = this.router.snapshot.params.platoId;
   }

  ngOnInit() {
    console.log(this.platoId);
  }

}
