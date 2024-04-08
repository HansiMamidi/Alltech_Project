import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DoctorSearchComponent } from './doctor-search/doctor-search.component';
import { AppointmentBookingComponent } from './appointment-booking/appointment-booking.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DoctorSearchComponent,
    AppointmentBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
