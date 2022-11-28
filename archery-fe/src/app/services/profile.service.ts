import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {ProfileResponse} from "../models/profile-response";
import {HttpClient} from "@angular/common/http";
import {FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {UserRoleRequest} from "../models/user-role-request";

const API_URL = 'http://localhost:8080/api/archery/';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient, private router: Router) {
  }

  getProfile(id: string): Observable<ProfileResponse> {
    return this.http.get<ProfileResponse>(API_URL + "user/" + id);
  }

  getProfiles(): Observable<ProfileResponse[]> {
    return this.http.get<ProfileResponse[]>(API_URL + "users");
  }

  postRole(form: FormGroup, userId: string) {
    const request: UserRoleRequest = {
      role: form.get('role')?.value
    };

    this.http.post<any>(API_URL + "user/" + userId, request)
      .subscribe(null, null, () => {
        this.router.navigate(["/profiles"]);
      });
  }
}
