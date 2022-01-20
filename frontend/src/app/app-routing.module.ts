import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainComponent} from "./components/main/main.component";
import {RawDataComponent} from "./components/raw-data/raw-data.component";
import {AnalyzedDataComponent} from "./components/analyzed-data/analyzed-data.component";

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
