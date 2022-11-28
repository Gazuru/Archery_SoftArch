import {Component, OnInit} from '@angular/core';
import {faPlus} from '@fortawesome/free-solid-svg-icons';
import {TrainingResponse} from "../../models/training-response";
import {TrainingService} from "../../services/training.service";

@Component({
  selector: 'app-trainings',
  templateUrl: './trainings.component.html',
  styleUrls: ['./trainings.component.css']
})
export class TrainingsComponent implements OnInit {
  faPlus = faPlus;
  trainings: TrainingResponse[] = [];

  constructor(private trainingService: TrainingService) {
  }

  ngOnInit(): void {
    this.trainingService.getTrainings().subscribe(
      data => {
        this.trainings = data;
      }
    );
  }

}
