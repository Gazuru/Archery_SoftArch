import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {BowResponse} from "../models/bow-response";
import {FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {TrainingResponse} from "../models/training-response";
import {TrainingRequest} from "../models/training-request";

const API_URL = 'http://localhost:8080/api/archery/';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  constructor(private http: HttpClient,private tokenStorageService: TokenStorageService) { }

  getTrainings(): Observable<TrainingResponse[]> {
    return this.http.get<TrainingResponse[]>(API_URL + 'bows');
  }

  getTraining(id:string): Observable<TrainingResponse> {
    return this.http.get<TrainingResponse>(API_URL + 'bow/'+id);
  }

  deleteTraining(id:string){
    this.http.delete(API_URL + "bow/"+id)
      .subscribe();
  }

  postTraining(form:FormGroup){
    const formData = new FormData();
    formData.append('name', form.get('name')?.value);
    formData.append('description', form.get('description')?.value);
    formData.append('shotsPerRound', form.get('shotsPerRound')?.value);
    formData.append('distance', form.get('distance')?.value);
    formData.append('maxPoints', form.get('maxPoints')?.value);
    formData.append('location', form.get('location')?.value);
    formData.append('board', form.get('board')?.value);

    this.http.post<TrainingRequest>(API_URL + "bows", formData)
      .subscribe(res => {
        console.log(res);
      });
  }

  putTraining(form:FormGroup,id:string) {
    const formData = new FormData();
    formData.append('name', form.get('name')?.value);
    formData.append('description', form.get('description')?.value);
    formData.append('shotsPerRound', form.get('shotsPerRound')?.value);
    formData.append('distance', form.get('distance')?.value);
    formData.append('maxPoints', form.get('maxPoints')?.value);
    formData.append('location', form.get('location')?.value);
    formData.append('board', form.get('board')?.value);

    this.http.patch<TrainingRequest>(API_URL + "bow/"+id, formData)
      .subscribe(res => {
        console.log(res);
      });
  }
}
