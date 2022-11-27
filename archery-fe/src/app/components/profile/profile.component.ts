import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../services/token-storage.service";
import {ActivatedRoute} from "@angular/router";
import {ProfileService} from "../../services/profile.service";
import {ProfileResponse} from "../../models/profile-response";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  private sub: any;

  profile: ProfileResponse = new ProfileResponse();

  constructor(private token: TokenStorageService, private route: ActivatedRoute, private profileService: ProfileService) {
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.profile = this.profileService.getProfile(params['id']);
    });
  }

}
