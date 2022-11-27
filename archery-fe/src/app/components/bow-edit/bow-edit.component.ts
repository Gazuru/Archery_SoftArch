import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BowService} from "../../services/bow.service";
import {BowResponse} from "../../models/bow-response";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-bow-edit',
  templateUrl: './bow-edit.component.html',
  styleUrls: ['./bow-edit.component.css']
})
export class BowEditComponent implements OnInit {
  types=["traditional","hunting_recurve","olympic_recurve","compound"];
  bow:BowResponse=new BowResponse();


  descriptionMinLength: number = 3;
  nameMinLength: number = 3;
  myForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(this.nameMinLength)]),
    description: new FormControl('', [Validators.required, Validators.minLength(this.descriptionMinLength)]),
    type: new FormControl('', [Validators.required])
  });

  private sub: any;
  constructor(private bowService:BowService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.bowService.getBow(params['id']).subscribe(
        (data)=>this.bow=data
      );
    });
  }

  get f() {
    return this.myForm.controls;
  }

  submit() {
    console.log(this.myForm.get('name')?.value+"__"+this.myForm.get('description')?.value+"__"+this.myForm.get('type')?.value);
    this.bowService.putBow(this.myForm,this.bow.id);
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
