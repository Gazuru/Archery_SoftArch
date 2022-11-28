import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {StatisticsResponse} from "../models/statistics-response";

const API_URL = 'http://localhost:8080/api/archery/';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService, private router: Router) {
  }

  getStatisticsById(statisticsId: string): Observable<StatisticsResponse> {
    return this.http.get<StatisticsResponse>(API_URL + 'statistics/' + statisticsId);
  }

  getUserStatistics(userId: string): Observable<StatisticsResponse> {
    return this.http.get<StatisticsResponse>(API_URL + userId + "/statistics");
  }

}
