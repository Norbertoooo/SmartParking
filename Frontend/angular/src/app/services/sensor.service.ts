import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sensor } from '../interfaces/sensor';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SensorService {
  constructor(private http: HttpClient) { }

  listarSensores(): Observable<Sensor[]> {
    const url = `${environment.apiUrl}/monitoramento`;
    return this.http.get<Sensor[]>(url);
  }

  estadoAtual(): Observable<Sensor> {
    const url = `${environment.apiUrl}/monitoramento/atual`;
    return this.http.get<Sensor>(url);
  }

}
