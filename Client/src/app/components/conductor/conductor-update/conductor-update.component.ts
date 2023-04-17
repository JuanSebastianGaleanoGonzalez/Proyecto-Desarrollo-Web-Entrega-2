import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';
import { ActivatedRoute, Router} from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-conductor-update',
  templateUrl: './conductor-update.component.html',
  styleUrls: ['./conductor-update.component.css']
})
export class ConductorUpdateComponent implements OnInit {
  conductor: Conductor = new Conductor();
  conductorForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private conductorService: ConductorService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) =>
          this.conductorService.findById(+params.get("id")!)
        )
      )
      .subscribe((conductor) => {
        this.conductor = conductor;
        this.conductorForm = this.fb.group({
          nombre: [this.conductor?.nombre ?? '', Validators.required],
          cedula: [this.conductor?.cedula ?? null, Validators.required],
          telefono: [this.conductor?.telefono ?? null, Validators.required],
          direccion: [this.conductor?.direccion ?? '', Validators.required],
        });
      });
  }

  public actualizarConductor(): void{    
    this.conductorService.update(this.conductor).subscribe(resp => {
      this.conductorForm?.reset();
      this.router.navigate(['/conductor/list']);      
    },
      error => console.error(error));
  }
}