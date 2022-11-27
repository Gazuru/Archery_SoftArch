import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-bow-row',
  templateUrl: './bow-row.component.html',
  styleUrls: ['./bow-row.component.css']
})
export class BowRowComponent implements OnInit {
  @Input() bow:any;

  constructor() { }

  ngOnInit(): void {
  }


}
