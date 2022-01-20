import { Component, OnInit } from '@angular/core';
import {faChartPie} from "@fortawesome/free-solid-svg-icons";
import {IconProp} from "@fortawesome/fontawesome-svg-core";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  title:string = "Analyzer";
  logo: IconProp = faChartPie;

  constructor() { }

  ngOnInit(): void {
  }

}
