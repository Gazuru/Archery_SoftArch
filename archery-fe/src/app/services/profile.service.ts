import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {ProfileResponse} from "../models/profile-response";
import {HttpClient} from "@angular/common/http";

const API_URL = 'http://localhost:8080/api/archery/';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

  getProfile(id:string): Observable<ProfileResponse> {
    return this.http.get<ProfileResponse>(API_URL + "profile/"+id);
  }

  getProfiles(): Observable<ProfileResponse[]> {
    return this.http.get<ProfileResponse[]>(API_URL + "profiles");
  }
}
