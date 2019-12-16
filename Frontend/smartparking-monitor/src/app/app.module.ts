import {HttpClientModule} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { TooltipModule } from 'ngx-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SensorComponent } from './componentes/sensor/sensor.component';
import {ReactiveFormsModule} from '@angular/forms';
import { FooterComponent } from './componentes/footer/footer.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { HistoricoComponent } from './componentes/historico/historico.component';
import {HistoricoModule} from './componentes/historico/historico.module';

@NgModule({
  declarations: [
    AppComponent,
    SensorComponent,
    FooterComponent,
    NavbarComponent,
    HistoricoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    TooltipModule.forRoot(),
    ReactiveFormsModule,
    HistoricoModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
