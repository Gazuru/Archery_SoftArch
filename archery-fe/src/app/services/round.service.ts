import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {BowResponse} from "../models/bow-response";
import {FormGroup} from "@angular/forms";
import {BowRequest} from "../models/bow-request";
import {HttpClient} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {Router} from "@angular/router";
import {RoundResponse} from "../models/round-response";
import {RoundRequest} from "../models/round-request";
const API_URL = 'http://localhost:8080/api/archery/';
@Injectable({
  providedIn: 'root'
})
export class RoundService {

  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService, private router: Router) { }

  getRounds(id:string): Observable<RoundResponse[]> {
    return this.http.get<RoundResponse[]>(API_URL + 'training/'+id+'/rounds');
  }

  /*getRound(id: string): Observable<RoundResponse> {
    return this.http.get<RoundResponse>(API_URL + 'bow/' + id);
  }*/

  deleteRound(id: string,trainingId:string) {
    this.http.delete(API_URL + "round/" + id)
      .subscribe(null, null, () => {
        this.router.navigate(["/training-details/"+trainingId]);
      });
  }

  postRound(form: FormGroup,trainingId:string) {
    const request: RoundRequest = {
      score: form.get('score')?.value
    };

    this.http.post<RoundResponse>(API_URL + "training/"+trainingId+"/rounds", request)
      .subscribe(res => {
        console.log(res);
      }, null, () => {
        this.router.navigate(["/training-details/"+trainingId]);
      });
  }

  putRound(form: FormGroup, trainingId: string,roundId:string) {
    const request: RoundRequest = {
      score: form.get('score')?.value
    };

    this.http.put<RoundResponse>(API_URL + "round/" + roundId, request)
      .subscribe(res => {
        console.log(res);
      }, null, () => {
        this.router.navigate(["/training-details/"+trainingId]);
      });
  }
}
