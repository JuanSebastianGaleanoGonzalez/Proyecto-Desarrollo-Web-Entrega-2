import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Ruta } from 'src/app/model/ruta/ruta';
import { RutaService } from 'src/app/services/ruta/ruta.service';

@Component({
  selector: 'app-ruta-update',
  templateUrl: './ruta-update.component.html',
  styleUrls: ['./ruta-update.component.css']
})
export class RutaUpdateComponent implements OnInit {

  ruta: Ruta = new Ruta();
  rutaForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private rutaService: RutaService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) =>
          this.rutaService.findById(+params.get("id")!)
        )
      )
      .subscribe((ruta) => {
        this.ruta = ruta;
        this.rutaForm = this.fb.group({
          codigo: [this.ruta?.codigo ?? null, Validators.required],
          nombre: [this.ruta?.nombre ?? '', Validators.required]
        });
      });
  }

  public actualizarRuta(): void{    
    this.rutaService.update(this.ruta).subscribe(resp => {
      this.rutaForm?.reset();
      this.router.navigate(['/ruta/list']);
    },
      error => console.error(error));
  }
}