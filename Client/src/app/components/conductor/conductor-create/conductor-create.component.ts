import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
@Component({
  selector: 'app-conductor-create',
  templateUrl: './conductor-create.component.html',
  styleUrls: ['./conductor-create.component.css']
})
export class ConductorCreateComponent {
  conductor: Conductor = new Conductor();
  conductores: any;
  conductorForm: FormGroup | undefined;
  constructor(private fb: FormBuilder, private conductorService: ConductorService, private router: Router) {
    this.conductorService.findAll().subscribe((conductores => {
      this.conductores = conductores;
    }))
  }

  public guardarConductor(): void {
      this.conductorService.create(this.conductor).subscribe(resp => {
        this.conductorForm?.reset();
        this.router.navigate(['/conductor/list'])
      },
        error => console.error(error));
  }
}