import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OpenAccountComponent} from "./components/open-account/open-account.component";
import {ShowDetailsComponent} from "./components/show-details/show-details.component";

const routes: Routes = [
    {path: 'open-account', component: OpenAccountComponent},
    {path: 'show-details', component: ShowDetailsComponent}
    ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
