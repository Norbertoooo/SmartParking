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

  listarTodosEstados(): Observable<Sensor[]> {
    const url = `${environment.apiUrl}/monitoramento`;
    return this.http.get<Sensor[]>(url);
  }

  estadoAtual(): Observable<Map<string,string>> {
    const url = `${environment.apiUrl}/monitoramento/atual`;
    //const urlteste = `${environment.apiUrl}/monitoramento/atual/Vaga-A1`;
    return this.http.get<Map<string,string>>(url);
  }

  listarTodosSensores(): Observable<[]>{
    const url = `${environment.apiUrl}/monitoramento/sensores`;
    return this.http.get<[]>(url);
  }

}
