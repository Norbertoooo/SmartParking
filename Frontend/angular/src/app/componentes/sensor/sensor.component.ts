import {Component, OnInit} from '@angular/core';
import {SensorService} from 'src/app/services/sensor.service';
import {Sensor} from 'src/app/interfaces/sensor';

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.scss']
})

export class SensorComponent implements OnInit {
  public listaDeTodosEstados: Sensor[];
  public estadoAtual: Map<string, string>;
  public listaDeSensores: Array<string>;

  constructor(private sensorService: SensorService) {
  }

  ngOnInit() {
    this.getEstadoAtual();
    this.listarTodosEstados();
    this.getlistaDeTodosSensores();
  }


  listarTodosEstados() {
    this.sensorService.listarTodosEstados().subscribe((sensor: Sensor[]) => {
        this.listaDeTodosEstados = sensor;
      }, error => {
        console.log(error);
      }
    );
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
