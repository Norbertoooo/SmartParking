import {Component, OnInit} from '@angular/core';
import {SensorService} from 'src/app/services/sensor.service';

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.scss']
})

export class SensorComponent implements OnInit {
  public estadoAtual: Map<string, string>;
  public listaDeSensores: Array<string>;

  constructor(private sensorService: SensorService) {
  }

  ngOnInit() {
    this.getEstadoAtual();
    this.getlistaDeTodosSensores();
  }

  getEstadoAtual() {
    this.sensorService.estadoAtual().subscribe((sensor: Map<string, string>) => {
        this.estadoAtual = sensor;
      }
    );
  }

  getlistaDeTodosSensores() {
    this.sensorService.listarTodosSensores().subscribe((coisa: Array<string>) => {
      this.listaDeSensores = coisa;
    });
  }

}
