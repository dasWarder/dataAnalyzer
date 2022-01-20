import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MainData} from "../../classes/raw/mainData";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private baseUrl:string = 'http://localhost:2230/api/v1/data';

  constructor(private httpClient: HttpClient) { }

  getAllRawData() {
    return this.httpClient.get<Array<MainData>>(`${this.baseUrl}/raw`);
  }

  getAllRawDataByAuthor(author: string) {
    return this.httpClient.get<Array<MainData>>(`${this.baseUrl}/raw`, {
      params: { 'author': author }
    });
  }
}
