import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DoctorSearchComponent } from './doctor-search/doctor-search.component';
import { AppointmentBookingComponent } from './appointment-booking/appointment-booking.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'doctor-search', component: DoctorSearchComponent },
  { path: 'appointment-booking', component: AppointmentBookingComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
