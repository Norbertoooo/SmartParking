import { Component, OnInit } from '@angular/core';
import { SensorService } from 'src/app/services/sensor.service';
import { Sensor } from 'src/app/interfaces/sensor';

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.scss']
})

export class SensorComponent implements OnInit {
  public sensor: Sensor[];
  public estadoAtual: Sensor;
  constructor(private sensorService: SensorService ) { }

  ngOnInit() {
    this.getListaSensores();
    this.getEstadoAtual()
  }

  getListaSensores() {
    this.sensorService.listarSensores()
    .subscribe((sensor: Sensor[]) => {
      this.sensor = sensor;
    });
  }
  getEstadoAtual() {
    this.sensorService.estadoAtual().
    subscribe((sensor: Sensor) =>{
      this.estadoAtual = sensor;
      }
    );
  }
}
