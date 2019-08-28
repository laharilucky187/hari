import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { HttpClientModule } from "@angular/common/http";
import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MenuComponent} from "./components/menu/menu.component";
import { OpenAccountComponent } from './components/open-account/open-account.component';
import { ShowDetailsComponent } from './components/show-details/show-details.component';
import {AlertService} from "./service/alert.service";
import {AlertComponent} from "./components/alert/alert.component";


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    OpenAccountComponent,
    ShowDetailsComponent,
    AlertComponent
  ],
  imports: [
  NgbModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AlertService],
  bootstrap: [AppComponent],
  exports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        NgbModule
    ]
})
export class AppModule { }
