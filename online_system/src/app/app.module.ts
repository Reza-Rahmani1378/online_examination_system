import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {SingupComponent} from './singup/singup/singup.component';
import {SignupComponent} from './signup/signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    SingupComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
