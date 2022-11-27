import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {TrainingResponse} from "../models/training-response";
import {TrainingRequest} from "../models/training-request";
import {Router} from "@angular/router";

const API_URL = 'http://localhost:8080/api/archery/';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService, private router: Router) {
  }

  getTrainings(): Observable<TrainingResponse[]> {
    return this.http.get<TrainingResponse[]>(API_URL + 'trainings'
    );
  }

//TODO
  getTrainingsByUserId(id: string): Observable<TrainingResponse[]> {
    return this.http.get<TrainingResponse[]>(API_URL + 'trainings',
      {
        params: {userId: id}
      });
  }


  getTraining(id: string): Observable<TrainingResponse> {
    return this.http.get<TrainingResponse>(API_URL + 'training/' + id);
  }

  deleteTraining(id: string) {
    this.http.delete(API_URL + "training/" + id)
      .subscribe(null, null, () => {
        this.router.navigate(["/trainings"]);
      });
  }

  postTraining(form: FormGroup) {
    const request: TrainingRequest = {
      name: form.get('name')?.value,
      description: form.get('description')?.value,
      shotsPerRound: form.get('shotsPerRound')?.value,
      distance: form.get('distance')?.value,
      maxPoints: form.get('maxPoints')?.value,
      location: form.get('location')?.value,
      isPrivate: form.get('isPrivate')?.value,
      bow: form.get('bow')?.value,
      board: form.get('board')?.value
    };

    this.http.post<TrainingResponse>(API_URL + "trainings", request)
      .subscribe(null, null, () => {
        this.router.navigate(["/trainings"]);
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
      isPrivate: form.get('isPrivate')?.value,
      bow: form.get('bow')?.value,
      board: form.get('board')?.value
    };
    this.http.put<TrainingResponse>(API_URL + "training/" + id, request)
      .subscribe(null, null, () => {
        this.router.navigate(["/trainings"]);
      });
  }
}
