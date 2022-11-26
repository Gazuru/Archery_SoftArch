import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BowResponse} from "../../models/bow-response";
import {BowService} from "../../services/bow.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-bow-new',
  templateUrl: './bow-new.component.html',
  styleUrls: ['./bow-new.component.css']
})
export class BowNewComponent implements OnInit {
  types=["traditional","hunting_recurve","olympic_recurve","compound"];

  descriptionMinLength: number = 3;
  nameMinLength: number = 3;
  myForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(this.nameMinLength)]),
    description: new FormControl('', [Validators.required, Validators.minLength(this.descriptionMinLength)]),
    type: new FormControl('', [Validators.required])
  });

  constructor(private bowService:BowService) { }

  ngOnInit(): void {
  }

  get f() {
    return this.myForm.controls;
  }

  submit() {
    console.log(this.myForm.get('name')?.value+"__"+this.myForm.get('description')?.value+"__"+this.myForm.get('type')?.value);
    this.bowService.postBow(this.myForm);
  }
}
