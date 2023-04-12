import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConductorEditForm } from 'src/app/forms/conductor-edit-form';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-conductor-update',
  templateUrl: './conductor-update.component.html',
  styleUrls: ['./conductor-update.component.css']
})
export class ConductorUpdateComponent implements OnInit {
  conductor: Conductor | undefined;
  conductorForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private coductorService: ConductorService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) =>
          this.coductorService.findById(+params.get("id")!)
        )
      )
      .subscribe((conductor) => {
        this.conductor = conductor;
        this.conductorForm = this.fb.group({
          nombre: [this.conductor?.nombre ?? "", Validators.required],
          cedula: [this.conductor?.cedula ?? null, Validators.required],
          telefono: [this.conductor?.telefono ?? null, Validators.required],
          direccion:[this.conductor?.direccion ?? "", Validators.required],
        });
      });
  }

  onSubmit() {
    let nombre = this.conductorForm.value.nombre;
    let cedula = this.conductorForm.value.cedula;
    let telefono = this.conductorForm.value.telefono;
    let direccion = this.conductorForm.value.direccion;

    let conductor: Conductor = new Conductor(nombre, cedula, telefono, direccion);
  }
}