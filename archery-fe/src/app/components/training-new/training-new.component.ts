import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TrainingService} from "../../services/training.service";

@Component({
  selector: 'app-training-new',
  templateUrl: './training-new.component.html',
  styleUrls: ['./training-new.component.css']
})
export class TrainingNewComponent implements OnInit {
  locations = ["indoors", "outdoors"];

  descriptionMinLength: number = 3;
  nameMinLength: number = 3;
  myForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(this.nameMinLength)]),
    description: new FormControl('', [Validators.required, Validators.minLength(this.descriptionMinLength)]),
    shotsPerRound: new FormControl('', [Validators.required, Validators.min(3)]),
    distance: new FormControl('', [Validators.required, Validators.min(5)]),
    maxPoints: new FormControl('', [Validators.required, Validators.min(10)]),
    location: new FormControl('', [Validators.required]),
    board: new FormControl('', [Validators.required, Validators.minLength(5)])
  });

  constructor(private trainingService: TrainingService) {
  }

  ngOnInit(): void {
  }

  get f() {
    return this.myForm.controls;
  }

  submit() {
    this.trainingService.postTraining(this.myForm);
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
