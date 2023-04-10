import { Component} from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Conductor } from 'src/app/model/conductor/conductor';
@Component({
  selector: 'app-conductor-update',
  templateUrl: './conductor-update.component.html',
  styleUrls: ['./conductor-update.component.css']
})
export class ConductorUpdateComponent {

  constructor(private fb: FormBuilder) { }

  conductorForm = this.fb.group({ // Utilización de FormBuilder
    nombre: ['', Validators.required],
    cedula: ['', Validators.required],
    telefono: ['', Validators.required],
    direccion: ['', Validators.required]
  });

  onSubmit(){
    const nombre = this.conductorForm.value.nombre;
    const cedula = this.conductorForm.value.cedula;
    const telefono = this.conductorForm.value.telefono;
    const direccion = this.conductorForm.value.direccion;

    if (nombre !== undefined && cedula !== undefined && telefono !== undefined && direccion !== undefined) {
      let conductor: Conductor = new Conductor(nombre, cedula, telefono, direccion);
    }
  }

}
