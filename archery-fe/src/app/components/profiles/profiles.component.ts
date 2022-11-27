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
    role: new FormControl('', [Validators.required])
  });

  currentEditUserId: string = "";

  showAdmin = false;

  constructor(private token: TokenStorageService, private profileService: ProfileService, private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.showAdmin = this.tokenStorageService.getUser().roles.includes('ROLE_ADMIN');

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
    this.profileService.postRole(this.myForm, this.currentEditUserId);
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

  setCurrentEditUser(id: string) {
    this.currentEditUserId = id;
  }
}
