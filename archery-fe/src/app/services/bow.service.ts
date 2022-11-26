import { Injectable } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {BowRequest} from "../models/bow-request";
import {Observable} from "rxjs";
import {BowResponse} from "../models/bow-response";

const API_URL = 'http://localhost:8080/api/archery/';

@Injectable({
  providedIn: 'root'
})
export class BowService {

  constructor(private http: HttpClient,private tokenStorageService: TokenStorageService) { }

  getBows(): Observable<BowResponse[]> {
    return this.http.get<BowResponse[]>(API_URL + 'bows');
  }

  getBow(id:string): Observable<BowResponse> {
    return this.http.get<BowResponse>(API_URL + 'bow/'+id);
  }

  deleteBow(id:string){
    this.http.delete(API_URL + "bow/"+id)
      .subscribe();
  }

  postBow(form:FormGroup){
    const formData = new FormData();
    formData.append('type', form.get('type')?.value);
    formData.append('name', form.get('name')?.value);
    formData.append('description', form.get('description')?.value);

    this.http.post<BowRequest>(API_URL + "bows", formData)
      .subscribe(res => {
        console.log(res);
      });
  }

  putBow(form:FormGroup,id:string) {
    const formData = new FormData();
    formData.append('type', form.get('type')?.value);
    formData.append('name', form.get('name')?.value);
    formData.append('description', form.get('description')?.value);

    this.http.patch<BowRequest>(API_URL + "bow/"+id, formData)
      .subscribe(res => {
        console.log(res);
      });
  }
}
