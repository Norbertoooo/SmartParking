import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {HistoricoComponent} from './historico.component';

const appRoutes: Routes = [
  { path: 'historico', component: HistoricoComponent },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule, RouterModule.forRoot(
      appRoutes,
      { enableTracing: true })
  ]
})

export class HistoricoModule { }
