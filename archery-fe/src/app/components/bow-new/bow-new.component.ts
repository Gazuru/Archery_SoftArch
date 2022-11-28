import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BowService} from "../../services/bow.service";

@Component({
  selector: 'app-bow-new',
  templateUrl: './bow-new.component.html',
  styleUrls: ['./bow-new.component.css']
})
export class BowNewComponent {
  types = ["traditional", "hunting_recurve", "olympic_recurve", "compound"];


  descriptionMinLength: number = 3;
  nameMinLength: number = 3;
  myForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(this.nameMinLength)]),
    description: new FormControl('', [Validators.required, Validators.minLength(this.descriptionMinLength)]),
    type: new FormControl('', [Validators.required])
  });

  constructor(private bowService: BowService) {
  }

  get f() {
    return this.myForm.controls;
  }

  submit() {
    this.bowService.postBow(this.myForm);
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
