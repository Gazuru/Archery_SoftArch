import {Component, OnInit} from '@angular/core';
import {TrainingResponse} from "../../models/training-response";
import {ActivatedRoute} from "@angular/router";
import {TrainingService} from "../../services/training.service";
import {RoundResponse} from "../../models/round-response";
import {RoundService} from "../../services/round.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-training-details',
  templateUrl: './training-details.component.html',
  styleUrls: ['./training-details.component.css']
})
export class TrainingDetailsComponent implements OnInit {
  training: TrainingResponse = new TrainingResponse();
  rounds: RoundResponse[] = [];
  disabled = false;

  maxRoundPoints = 0;
  myForm = new FormGroup({
    score: new FormControl('', [Validators.required, Validators.min(0), Validators.max(this.maxRoundPoints)])
  });

  constructor(private trainingService: TrainingService, private roundService: RoundService, private route: ActivatedRoute) {
  }

  private sub: any;

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.trainingService.getTraining(params['id']).subscribe(data => {
        this.training = data;
      }, null, () => {
        this.maxRoundPoints = this.training.maxPoints * this.training.shotsPerRound;
        this.myForm = new FormGroup({
          score: new FormControl('', [Validators.required, Validators.min(0), Validators.max(this.maxRoundPoints)])
        });
        this.roundService.getRounds(this.training.id).subscribe(
          data => {
            this.rounds = data;
          }
        );
      });
    });
  }

  deleteTraining() {
    this.trainingService.deleteTraining(this.training.id);
  }

  get f() {
    return this.myForm.controls;
  }

  addRound() {
    this.roundService.postRound(this.myForm, this.training.id);
  }

  getDisplayNameForValue(value: string): string {
    switch (value) {
      case "indoors": {
        return "Indoors";
      }
      case "outdoors": {
        return "Outdoors";
      }
      default:
        return "Not found";
    }
  }


}
