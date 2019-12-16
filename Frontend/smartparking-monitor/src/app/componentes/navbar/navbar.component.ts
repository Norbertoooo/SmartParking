import { Component, OnInit } from '@angular/core';
import {SensorService} from '../../services/sensor.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(private sensorService: SensorService ) { }

  ngOnInit() {
  }

  deletarTudo() {
   this.sensorService.deletarTodosRegistros();
  }

}
