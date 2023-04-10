import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Conductor } from 'src/app/model/conductor/conductor';
import { ConductorService } from 'src/app/services/conductor/conductor.service';

@Component({
  selector: 'app-conductor-list',
  templateUrl: './conductor-list.component.html',
  styleUrls: ['./conductor-list.component.css']
})
export class ConductorListComponent implements OnInit {

  conductores: Conductor[] = []; 
  constructor(
    private conductorService: ConductorService
  ) { }

  ngOnInit(): void {
    this.conductorService.findAll().subscribe(conductores => this.conductores = conductores);
  }

}