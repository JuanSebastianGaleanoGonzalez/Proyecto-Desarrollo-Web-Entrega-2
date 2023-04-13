import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Ruta } from 'src/app/model/ruta/ruta';

@Component({
  selector: 'app-ruta-create',
  templateUrl: './ruta-create.component.html',
  styleUrls: ['./ruta-create.component.css']
})
export class RutaCreateComponent  {

  constructor(private fb: FormBuilder) { }

}