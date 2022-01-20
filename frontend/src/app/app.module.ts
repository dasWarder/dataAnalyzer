import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RawDataComponent } from './raw-data/raw-data.component';
import { MainComponent } from './main/main.component';
import { AnalyzedDataComponent } from './analyzed-data/analyzed-data.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RawDataComponent,
    MainComponent,
    AnalyzedDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
