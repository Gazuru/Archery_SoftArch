import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
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

  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService) {
  }

  getTrainings(): Observable<TrainingResponse[]> {
    return this.http.get<TrainingResponse[]>(API_URL + 'trainings');
  }

  getTraining(id: string): Observable<TrainingResponse> {
    return this.http.get<TrainingResponse>(API_URL + 'training/' + id);
  }

  deleteTraining(id: string) {
    this.http.delete(API_URL + "training/" + id)
      .subscribe();
  }

  postTraining(form: FormGroup) {
    const request: TrainingRequest = {
      name: form.get('name')?.value,
      description: form.get('description')?.value,
      shotsPerRound: form.get('shotsPerRound')?.value,
      distance: form.get('distance')?.value,
      maxPoints: form.get('maxPoints')?.value,
      location: form.get('location')?.value,
      board: form.get('board')?.value
    };

    this.http.post<TrainingResponse>(API_URL + "trainings", request)
      .subscribe(res => {
        console.log(res);
      });
  }

  putTraining(form: FormGroup, id: string) {
    const request: TrainingRequest = {
      name: form.get('name')?.value,
      description: form.get('description')?.value,
      shotsPerRound: form.get('shotsPerRound')?.value,
      distance: form.get('distance')?.value,
      maxPoints: form.get('maxPoints')?.value,
      location: form.get('location')?.value,
      board: form.get('board')?.value
    };
    this.http.patch<TrainingResponse>(API_URL + "training/" + id, request)
      .subscribe(res => {
        console.log(res);
      });
  }
}
