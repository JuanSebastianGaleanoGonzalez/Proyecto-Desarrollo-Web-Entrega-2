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