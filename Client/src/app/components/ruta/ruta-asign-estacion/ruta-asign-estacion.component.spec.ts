import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaAsignEstacionComponent } from './ruta-asign-estacion.component';

describe('RutaAsignEstacionComponent', () => {
  let component: RutaAsignEstacionComponent;
  let fixture: ComponentFixture<RutaAsignEstacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutaAsignEstacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaAsignEstacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
