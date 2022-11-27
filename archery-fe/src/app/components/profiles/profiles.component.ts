import {Component, OnInit} from '@angular/core';
import {ProfileResponse} from "../../models/profile-response";
import {TokenStorageService} from "../../services/token-storage.service";
import {ProfileService} from "../../services/profile.service";

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {
  profiles: ProfileResponse[] = [];

  constructor(private token: TokenStorageService, private profileService: ProfileService) {
  }

  ngOnInit(): void {
    this.profileService.getProfiles().subscribe(
      data => {
        this.profiles = data;
      }
    );
  }

}
