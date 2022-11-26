import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-training-row',
  templateUrl: './training-row.component.html',
  styleUrls: ['./training-row.component.css']
})
export class TrainingRowComponent implements OnInit {
  training:any;
  constructor() { }

  ngOnInit(): void {
  }

}
