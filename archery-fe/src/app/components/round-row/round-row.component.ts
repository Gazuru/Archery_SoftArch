import {Component, Input, OnInit} from '@angular/core';
import {RoundService} from "../../services/round.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TrainingService} from "../../services/training.service";
import {TrainingResponse} from "../../models/training-response";
import {faTrashCan, faWrench} from "@fortawesome/free-solid-svg-icons";
import {TokenStorageService} from "../../services/token-storage.service";

@Component({
  selector: 'app-round-row',
  templateUrl: './round-row.component.html',
  styleUrls: ['./round-row.component.css']
})
export class RoundRowComponent implements OnInit {
  @Input() round: any;
  faWrench = faWrench;
  faTrashCan = faTrashCan;

  training: TrainingResponse = new TrainingResponse();

  maxRoundPoints = 0;
  myForm = new FormGroup({
    score: new FormControl('', [Validators.required, Validators.min(0), Validators.max(this.maxRoundPoints)])
  });

  public userOwned: boolean = false;
  public showAdmin: boolean = false;

  constructor(private roundService: RoundService, private trainingService: TrainingService, private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.trainingService.getTraining(this.round.trainingId).subscribe(data => {
      this.training = data;
      this.userOwned = this.tokenStorageService.getUserId() === data.user;
      this.showAdmin = this.tokenStorageService.isAdmin();
    }, null, () => {
      this.maxRoundPoints = this.training.maxPoints * this.training.shotsPerRound;
      this.myForm = new FormGroup({
        score: new FormControl(this.round.score, [Validators.required, Validators.min(0), Validators.max(this.maxRoundPoints)])
      });

    });
  }

  get f() {
    return this.myForm.controls;
  }


  editRound() {
    this.roundService.putRound(this.myForm, this.round.trainingId, this.round.id);
    window.location.reload();
  }

  deleteRound() {
    this.roundService.deleteRound(this.round.id, this.training.id);
    window.location.reload();
  }

}

