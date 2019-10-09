import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SensorserviceService {

  private readonly URL = 'http://localhost:8081/api/monitoramento/';
  constructor(private http: HttpClient) { }
  listar() {
    return this.http.get<any>(this.URL);
  }
}
