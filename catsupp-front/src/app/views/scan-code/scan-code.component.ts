import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router"

@Component({
  selector: 'app-scan-code',
  templateUrl: './scan-code.component.html',
  styleUrls: ['./scan-code.component.css']
})
export class ScanCodeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    this.scannerEnabled = true;
  }

  scannerEnabled : boolean;

  scanSuccessHandler(idLocal: string){
    this.router.navigate(['/carta', idLocal])
  }
}
