import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-bow-row',
  templateUrl: './bow-row.component.html',
  styleUrls: ['./bow-row.component.css']
})
export class BowRowComponent implements OnInit {
  @Input() bow: any;

  constructor() {
  }

  ngOnInit(): void {
  }

  getDisplayNameForValue(value: string): string {
    switch (value) {
      case "traditional": {
        return "Traditional";
      }
      case "hunting_recurve": {
        return "Hunting recurve";
      }
      case "olympic_recurve": {
        return "Olympic recurve";
      }
      case "compound": {
        return "Compound";
      }
      default:
        return "Not found";
    }
  }

}
