import { Component, OnInit } from '@angular/core';
import {TrainingResponse} from "../../models/training-response";

@Component({
  selector: 'app-training-details',
  templateUrl: './training-details.component.html',
  styleUrls: ['./training-details.component.css']
})
export class TrainingDetailsComponent implements OnInit {
  training:TrainingResponse=new TrainingResponse();
  constructor() { }

  ngOnInit(): void {
  }

  deleteTraining() {

  }
}
