import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-bow-new',
  templateUrl: './bow-new.component.html',
  styleUrls: ['./bow-new.component.css']
})
export class BowNewComponent implements OnInit {
  types=["X","Y","Z"];

  descriptionMinLength: number = 3;
  nameMinLength: number = 3;
  myForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(this.nameMinLength)]),
    description: new FormControl('', [Validators.required, Validators.minLength(this.descriptionMinLength)]),
    type: new FormControl('', [Validators.required])
  });
  constructor() { }

  ngOnInit(): void {
  }

  get f() {
    return this.myForm.controls;
  }

  submit() {
    console.log(this.myForm.get('name')?.value+"__"+this.myForm.get('description')?.value+"__"+this.myForm.get('type')?.value);
  }
}
