import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MultiformComponent } from './multiform/multiform.component';

const routes: Routes = [
  {
    path:"",
    component:MultiformComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
