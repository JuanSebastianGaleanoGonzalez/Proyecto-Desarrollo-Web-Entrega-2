import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-transmilenio-create',
  templateUrl: './transmilenio-create.component.html',
  styleUrls: ['./transmilenio-create.component.css']
})
export class TransmilenioCreateComponent {
  transmilenio: Transmilenio = new Transmilenio();
  transmilenios: any;
  transmilenioForm: FormGroup | undefined;
  constructor(private fb: FormBuilder, private transmilenioService:TransmilenioService, private router:Router) { }

  public guardarTransmilenio(): void {
    this.transmilenioService.create(this.transmilenio).subscribe(resp => {
      this.transmilenioForm?.reset();
      this.router.navigate(['/transmilenio/list'])
    },
      error => console.error(error));
  }

}
