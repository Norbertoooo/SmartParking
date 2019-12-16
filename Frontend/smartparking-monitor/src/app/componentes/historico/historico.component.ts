import { Component, OnInit } from '@angular/core';
import {Sensor} from '../../interfaces/sensor';
import {SensorService} from '../../services/sensor.service';

@Component({
  selector: 'app-historico',
  templateUrl: './historico.component.html',
  styleUrls: ['./historico.component.scss']
})
export class HistoricoComponent implements OnInit {
  public listaDeTodosEstados: Sensor[];

  constructor(private sensorService: SensorService) { }

  ngOnInit() {
        this.listarTodosEstados();
  }

  listarTodosEstados() {
    this.sensorService.listarTodosEstados().subscribe((sensor: Sensor[]) => {
        this.listaDeTodosEstados = sensor;
      }, error => {
        console.log(error);
      }
    );
  }
}
