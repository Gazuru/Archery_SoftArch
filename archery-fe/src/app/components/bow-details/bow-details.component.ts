import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bow-details',
  templateUrl: './bow-details.component.html',
  styleUrls: ['./bow-details.component.css']
})
export class BowDetailsComponent implements OnInit {
  bow:any;
  constructor() { }

  ngOnInit(): void {
  }

  deleteBow() {

  }
}
