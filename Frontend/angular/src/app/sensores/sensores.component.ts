import { Component, OnInit } from '@angular/core';
import { SensorserviceService } from './sensorservice.service';
import {delay} from 'rxjs/operators';

@Component({
  selector: 'app-sensores',
  templateUrl: './sensores.component.html',
  styleUrls: ['./sensores.component.css']
})
export class SensoresComponent implements OnInit {

  dados: Array<any>;

  constructor(private sensorserviceService: SensorserviceService) { }

  ngOnInit() {
    this.listar();
    // this.pageRefresh();
  }

  listar() {
    this.sensorserviceService.listar().subscribe(res => this.dados = res);
  }
  pageRefresh() {
    location.reload();
  }



}
