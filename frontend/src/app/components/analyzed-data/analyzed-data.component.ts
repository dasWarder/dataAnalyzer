import {Component, OnInit} from '@angular/core';
import {DataService} from "../../services/data/data.service";

@Component({
  selector: 'app-analyzed-data',
  templateUrl: './analyzed-data.component.html',
  styleUrls: ['./analyzed-data.component.scss']
})
export class AnalyzedDataComponent implements OnInit {

  author: string = '';
  creatingDate: string = '';

  viewModel: any = {
    author: null,
    creatingDate: null,
    messagesCount: null
  };

  constructor(private dataService: DataService) {
  }

  ngOnInit(): void {
  }

  getDataByParams = () => {

    if (this.author != null && this.author != undefined && this.creatingDate === null || this.creatingDate === undefined) {
      this.getDataByAuthor();
    }

    if (this.creatingDate != null && this.creatingDate != undefined && this.author === null || this.author === undefined) {
      this.getDataByDate();
    }

    if (this.author != null && this.author != undefined && this.creatingDate != null || this.creatingDate != undefined) {
      this.getDataByAuthorAndDate();
    }
  }

  private getDataByAuthor = () => {
    this.dataService.getAnalyzedDataByAuthor(this.author).subscribe({
      next: value => {
        console.log('In AnalyzedDataComponent.getDataByAuthor - fetch by author = ' + this.author);
        this.viewModel = value
      },
      error: err => console.error(`In AnalyzedDataComponent.getDataByAuthor -  an exception occurred ${err.message}`)
    });
  }

  private getDataByDate = () => {
    this.dataService.getAnalyzedDataByCreatingDate(this.creatingDate).subscribe({
      next: value => {
        console.log('In AnalyzedDataComponent.getDataByDate - fetch by date = ' + this.creatingDate);
        this.viewModel = value
      },
      error: err => console.error(`In AnalyzedDataComponent.getDataByDate -  an exception occurred ${err.message}`)
    });
  }

  private getDataByAuthorAndDate = () => {

    if (this.author === '' && this.creatingDate != '') {
      this.getDataByDate();
      return;
    }

    if (this.creatingDate === '' && this.author != '') {
      this.getDataByAuthor();
      return;
    }

    this.dataService.getAnalyzedDataByAuthorAndCreatingDate(this.author, this.creatingDate).subscribe({
      next: value => {
        console.log('In AnalyzedDataComponent.getDataByAuthorAndCreatingDate - fetch by author = ' + this.author + ' and creating date = ' + this.creatingDate);
        this.viewModel = value
      },
      error: err => console.error(`In AnalyzedDataComponent.getDataByAuthorAndCreatingDate -  an exception occurred ${err.message}`)
    });
  }

}
