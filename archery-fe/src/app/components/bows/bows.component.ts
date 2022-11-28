import {Component, OnInit} from '@angular/core';
import {faPlus} from '@fortawesome/free-solid-svg-icons';
import {BowService} from "../../services/bow.service";
import {BowResponse} from "../../models/bow-response";


@Component({
  selector: 'app-bows',
  templateUrl: './bows.component.html',
  styleUrls: ['./bows.component.css']
})
export class BowsComponent implements OnInit {
  faPlus = faPlus;
  bows: BowResponse[] = [];

  constructor(private bowService: BowService) {
  }

  ngOnInit(): void {
    this.bowService.getBows().subscribe(
      data => {
        this.bows = data;
      }
    );
  }

}
