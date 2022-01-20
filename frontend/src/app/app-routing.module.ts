import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainComponent} from "./main/main.component";
import {RawDataComponent} from "./raw-data/raw-data.component";
import {AnalyzedDataComponent} from "./analyzed-data/analyzed-data.component";

const routes: Routes = [
  { path: 'about', component: MainComponent },
  { path: '', redirectTo: 'about', pathMatch: 'full' },
  { path: 'raw', component: RawDataComponent },
  { path: 'analyzed', component: AnalyzedDataComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
