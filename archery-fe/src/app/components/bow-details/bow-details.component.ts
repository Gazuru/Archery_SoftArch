import { Component, OnInit } from '@angular/core';
import {BowResponse} from "../../models/bow-response";
import {BowService} from "../../services/bow.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-bow-details',
  templateUrl: './bow-details.component.html',
  styleUrls: ['./bow-details.component.css']
})
export class BowDetailsComponent implements OnInit {
  bow:BowResponse=new BowResponse();
  constructor(private bowService:BowService, private route:ActivatedRoute) { }


  private sub: any;
  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.bowService.getBow(params['id']).subscribe(data=>{
        this.bow=data;
      });
    });
  }

  deleteBow() {
    this.bowService.deleteBow(this.bow.id);
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
