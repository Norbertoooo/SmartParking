import {HttpClientModule} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SensoresComponent } from './sensores/sensores.component';
import {SensorserviceService} from './sensorservice.service';

@NgModule({
  declarations: [
    AppComponent,
    SensoresComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SensorserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
