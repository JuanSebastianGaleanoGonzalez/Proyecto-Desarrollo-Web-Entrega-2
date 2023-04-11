import { Component, OnInit } from '@angular/core';
import { Transmilenio } from 'src/app/model/transmilenio/transmilenio';
import { TransmilenioService } from 'src/app/services/transmilenio/transmilenio.service';

@Component({
  selector: 'app-transmilenio-list',
  templateUrl: './transmilenio-list.component.html',
  styleUrls: ['./transmilenio-list.component.css']
})
export class TransmilenioListComponent implements OnInit {

  transmilenios: Transmilenio[] = [];
  constructor(
    private transmilenioService: TransmilenioService
  ) { }

  ngOnInit(): void {
    this.transmilenioService.findAll().subscribe(transmilenios => this.transmilenios = transmilenios);
  }

}
