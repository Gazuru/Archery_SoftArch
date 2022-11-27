import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../services/token-storage.service";
import {ActivatedRoute} from "@angular/router";
import {ProfileService} from "../../services/profile.service";
import {ProfileResponse} from "../../models/profile-response";
import {TrainingResponse} from "../../models/training-response";
import {TrainingService} from "../../services/training.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  private sub: any;

  profile: ProfileResponse = new ProfileResponse();
  trainings: TrainingResponse[]=[];
  constructor(private token: TokenStorageService, private route: ActivatedRoute, private profileService: ProfileService,private trainingService:TrainingService) {
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.profileService.getProfile(params['id']).subscribe(
        data => {
          this.profile = data;
        },null,()=>{
          this.trainingService.getTrainingsByUserId(this.profile.id).subscribe(
            data=>{
              this.trainings=data;
            }
          )
        }
      );
    });
  }

}
