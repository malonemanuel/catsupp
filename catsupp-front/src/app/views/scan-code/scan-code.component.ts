import { Component, OnInit } from '@angular/core';
import { ZXingScannerModule } from '@zxing/ngx-scanner';

@Component({
  selector: 'app-scan-code',
  templateUrl: './scan-code.component.html',
  styleUrls: ['./scan-code.component.css']
})
export class ScanCodeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  scanSuccess(idLocal: string){
    console.log(idLocal);
  }
}
