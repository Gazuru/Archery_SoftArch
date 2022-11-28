import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-training-row',
  templateUrl: './training-row.component.html',
  styleUrls: ['./training-row.component.css']
})
export class TrainingRowComponent {

  @Input() training: any;

  constructor() {
  }

}
