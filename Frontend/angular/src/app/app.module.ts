import {HttpClientModule} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TooltipModule } from 'ngx-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SensorComponent } from './componentes/sensor/sensor.component';

@NgModule({
  declarations: [
    AppComponent,
    SensorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    TooltipModule.forRoot()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
