import {Injectable} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {Observable} from "rxjs";
import {BowResponse} from "../models/bow-response";
import {BowRequest} from "../models/bow-request";
import {Router} from "@angular/router";

const API_URL = 'http://localhost:8080/api/archery/';

@Injectable({
  providedIn: 'root'
})
export class BowService {

  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService, private router: Router) {
  }

  getBows(): Observable<BowResponse[]> {
    return this.http.get<BowResponse[]>(API_URL + 'bows');
  }

  getBow(id: string): Observable<BowResponse> {
    return this.http.get<BowResponse>(API_URL + 'bow/' + id);
  }

  deleteBow(id: string) {
    this.http.delete(API_URL + "bow/" + id)
      .subscribe(null, null, () => {
        this.router.navigate(["/bows"]);
      });
  }

  postBow(form: FormGroup) {
    const request: BowRequest = {
      name: form.get('name')?.value,
      type: form.get('type')?.value,
      description: form.get('description')?.value
    };

    this.http.post<BowResponse>(API_URL + "bows", request)
      .subscribe(res => {
        console.log(res);
      }, null, () => {
        this.router.navigate(["/bows"]);
      });
  }

  putBow(form: FormGroup, id: string) {
    const request: BowRequest = {
      name: form.get('name')?.value,
      type: form.get('type')?.value,
      description: form.get('description')?.value
    };

    this.http.put<BowResponse>(API_URL + "bow/" + id, request)
      .subscribe(res => {
        console.log(res);
      }, null, () => {
        this.router.navigate(["/bows"]);
      });
  }
}
