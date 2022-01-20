import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MainData} from "../../classes/raw/mainData";
import {AnalysisAuthorData} from "../../classes/analyzed/analysisAuthorData";
import {AnalysisDateData} from "../../classes/analyzed/analysisDateData";
import {AnalysisAuthorDateData} from "../../classes/analyzed/analysisAuthorDateData";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private baseUrl: string = 'http://localhost:2230/api/v1/data';

  constructor(private httpClient: HttpClient) {
  }

  getAllRawData() {
    return this.httpClient.get<Array<MainData>>(`${this.baseUrl}/raw`);
  }

  getAllRawDataByAuthor(author: string) {
    return this.httpClient.get<Array<MainData>>(`${this.baseUrl}/raw`, {
      params: {'author': author}
    });
  }

  getAnalyzedDataByAuthor = (author: string) => {

    if (author != undefined && author != null) {
      return this.httpClient.get<AnalysisAuthorData>(`${this.baseUrl}/analysis`, {
        params: {'author': author}
      });
    }
    throw new Error(`In DataService.getAnalyzedDataByAuthor - author name undefined`);
  }

  getAnalyzedDataByCreatingDate = (creatingDate: string) => {

    if (creatingDate != undefined && creatingDate != null) {

      return this.httpClient.get<AnalysisDateData>(`${this.baseUrl}/analysis`, {
        params: {'creatingDate': creatingDate}
      });
    }
    throw new Error(`In DataService.getAnalyzedDataByCreatingDate - creating date undefined`);
  }

  getAnalyzedDataByAuthorAndCreatingDate = (author: string, creatingDate: string) => {

    if (author != '' && creatingDate != '') {

      return this.httpClient.get<AnalysisAuthorDateData>(`${this.baseUrl}/analysis`, {
        params: {'author': author, 'creatingDate': creatingDate}
      });
    }
    throw new Error(`In DataService.getAnalyzedDataByAuthorAndCreatingDate - author name or creating name undefined`);
  }
}
