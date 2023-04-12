import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { RutaEditForm } from 'src/app/forms/ruta-edit-form';
import { Ruta } from 'src/app/model/ruta/ruta';

@Component({
  selector: 'app-ruta-create',
  templateUrl: './ruta-create.component.html',
  styleUrls: ['./ruta-create.component.css']
})
export class RutaCreateComponent  {

  constructor(private fb: FormBuilder) { }

  rutaForm = this.fb.group<RutaEditForm>({ // Utilización de FormBuilder
    codigo: this.fb.control(null, [Validators.required, Validators.pattern(/^\d+$/), Validators.minLength(2)])
  });

  onSubmit(){
    let codigo = this.rutaForm.value.codigo;
    let ruta: Ruta = new Ruta(codigo);
  }
}