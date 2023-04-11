import { Component} from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ConductorEditForm } from 'src/app/forms/conductor-edit-form';
import { Conductor } from 'src/app/model/conductor/conductor';
@Component({
  selector: 'app-conductor-create',
  templateUrl: './conductor-create.component.html',
  styleUrls: ['./conductor-create.component.css']
})
export class ConductorCreateComponent {

  constructor(private fb: FormBuilder) { }

  conductorForm = this.fb.group<ConductorEditForm>({ // Utilización de FormBuilder
    nombre: this.fb.control('', [Validators.required]),
    cedula: this.fb.control(null, [Validators.required, Validators.pattern(/^\d+$/), Validators.minLength(2)]),
    telefono: this.fb.control(null, [Validators.required, Validators.pattern(/^\d+$/), Validators.minLength(2)]),
    direccion: this.fb.control('', [Validators.required])
  });

  onSubmit(){
    let nombre = this.conductorForm.value.nombre;
    let cedula = this.conductorForm.value.cedula;
    let telefono = this.conductorForm.value.telefono;
    let direccion = this.conductorForm.value.direccion;

    //if (nombre !== undefined && nombre !== null && cedula !== undefined && cedula !== null && telefono !== undefined && telefono !== null && direccion !== undefined && direccion !== null) {
      let conductor: Conductor = new Conductor(nombre, cedula, telefono, direccion);
    //}
  }

}