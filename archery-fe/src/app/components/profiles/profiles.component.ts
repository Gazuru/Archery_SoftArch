import {Component, OnInit} from '@angular/core';
import {ProfileResponse} from "../../models/profile-response";
import {TokenStorageService} from "../../services/token-storage.service";
import {ProfileService} from "../../services/profile.service";
import {faWrench} from "@fortawesome/free-solid-svg-icons";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {
  profiles: ProfileResponse[] = [];
  faWrench = faWrench;
  roles = ["ROLE_ADMIN", "ROLE_USER"]

  myForm = new FormGroup({
    score: new FormControl('', [Validators.required])
  });

  currentEditUserId: string = "";
  currentEditUserRole: string = "";

  constructor(private token: TokenStorageService, private profileService: ProfileService) {
  }

  ngOnInit(): void {
    this.profileService.getProfiles().subscribe(
      data => {
        this.profiles = data;
      }
    );
  }

  get f() {
    return this.myForm.controls;
  }

  editUserRole() {

  }

  getDisplayNameForValue(value: string): string {
    switch (value) {
      case "ROLE_ADMIN": {
        return "Admin";
      }
      case "ROLE_USER": {
        return "User";
      }
      default:
        return "Not found";
    }
  }

  setCurrentEditUser(id: string, role: string) {
    this.currentEditUserId = id;
    this.currentEditUserRole = role;
  }
}
