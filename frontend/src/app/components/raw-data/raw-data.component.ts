import {Component, OnInit} from '@angular/core';
import {DataService} from "../../services/data/data.service";
import {Router} from "@angular/router";
import {MainData} from "../../classes/raw/mainData";

@Component({
  selector: 'app-raw-data',
  templateUrl: './raw-data.component.html',
  styleUrls: ['./raw-data.component.scss']
})
export class RawDataComponent implements OnInit {

  rawData: Array<MainData> = [];
  author: string = "";
  isFilterOpen = false;

  constructor(private dataService: DataService) {
  }

  ngOnInit(): void {
    this.getAllData();
  }

  getAllData = () => {

    this.dataService.getAllRawData().subscribe({
      next: value => {
        console.log(`In RawDataComponent.getAllData - Fetch all raw data`);
        this.rawData = value
      },
      error: err => console.log('In RawDataComponent.getAllData - An exception occurred ' + err.message)
    });
  }

  getAllDataByAuthor = () => {

    this.dataService.getAllRawDataByAuthor(this.author).subscribe({
      next: value => {
        console.log(`In RawDataComponent.getAllDataByAuthor - Fetch all raw data by author = ${this.author}`);
        this.rawData = value
      },
      error: err => console.log('In RawDataComponent.getAllDataByAuthor - An exception occurred ' + err.message)
    });
  }

}
