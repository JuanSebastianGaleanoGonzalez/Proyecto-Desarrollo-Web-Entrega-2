import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';

@Component({
  selector: 'app-transmilenio-create',
  templateUrl: './transmilenio-create.component.html',
  styleUrls: ['./transmilenio-create.component.css']
})
export class TransmilenioCreateComponent {

  constructor(private fb: FormBuilder) { }

}
