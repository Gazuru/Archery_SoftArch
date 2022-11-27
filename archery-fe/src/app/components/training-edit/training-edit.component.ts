import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TrainingService} from "../../services/training.service";
import {BowResponse} from "../../models/bow-response";
import {ActivatedRoute} from "@angular/router";
import {TrainingResponse} from "../../models/training-response";

@Component({
  selector: 'app-training-edit',
  templateUrl: './training-edit.component.html',
  styleUrls: ['./training-edit.component.css']
})
export class TrainingEditComponent implements OnInit {
  locations = ["indoors", "outdoors"];
  training:TrainingResponse=new TrainingResponse();

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

  private sub: any;
  constructor(private trainingService: TrainingService,private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.trainingService.getTraining(params['id']).subscribe(
        (data)=>this.training=data
      );
    });
  }

  get f() {
    return this.myForm.controls;
  }

  submit() {
   this.trainingService.putTraining(this.myForm,this.training.id);
  }

  deleteTraining(){

  }
}
