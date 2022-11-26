import { Component, OnInit } from '@angular/core';
import {BowResponse} from "../../models/bow-response";
import {BowService} from "../../services/bow.service";

@Component({
  selector: 'app-bow-details',
  templateUrl: './bow-details.component.html',
  styleUrls: ['./bow-details.component.css']
})
export class BowDetailsComponent implements OnInit {
  bow:BowResponse=new BowResponse();
  constructor(private bowService:BowService) { }

  ngOnInit(): void {
  }

  deleteBow() {
    this.bowService.deleteBow(this.bow.id);
  }
}
