import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { TransmilenioEditForm } from 'src/app/forms/transmilenio-edit-form';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';

@Component({
  selector: 'app-transmilenio-create',
  templateUrl: './transmilenio-create.component.html',
  styleUrls: ['./transmilenio-create.component.css']
})
export class TransmilenioCreateComponent {

  constructor(private fb: FormBuilder) { }

  transmilenioForm = this.fb.group<TransmilenioEditForm>({ // Utilización de FormBuilder
    placa: this.fb.control(null, [Validators.required, Validators.pattern(/^\d+$/), Validators.minLength(2)]),
    modelo: this.fb.control(null, [Validators.required, Validators.pattern(/^\d+$/), Validators.minLength(2)])
  });

  onSubmit(){
    let placa = this.transmilenioForm.value.placa;
    let modelo = this.transmilenioForm.value.modelo;
    //if (placa !== undefined && placa !== null && modelo !== undefined && modelo !== null) {
      let conductor: Transmilenio = new Transmilenio(placa, modelo);
    //}
  }

}
