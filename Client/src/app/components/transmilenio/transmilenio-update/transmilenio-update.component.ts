import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-transmilenio-update',
  templateUrl: './transmilenio-update.component.html',
  styleUrls: ['./transmilenio-update.component.css']
})
export class TransmilenioUpdateComponent implements OnInit {

  transmilenio: Transmilenio | undefined;
  transmilenioForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private transmilenioService: TransmilenioService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) =>
          this.transmilenioService.findById(+params.get("id")!)
        )
      )
      .subscribe((transmilenio) => {
        this.transmilenio = transmilenio;
        this.transmilenioForm = this.fb.group({
          placa: [this.transmilenio?.placa ?? null, Validators.required],
          modelo: [this.transmilenio?.modelo ?? null, Validators.required]
        });
      });
  }
}