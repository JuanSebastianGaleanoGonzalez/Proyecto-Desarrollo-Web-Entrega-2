import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaAsignHorarioComponent } from './ruta-asign-horario.component';

describe('RutaAsignHorarioComponent', () => {
  let component: RutaAsignHorarioComponent;
  let fixture: ComponentFixture<RutaAsignHorarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutaAsignHorarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaAsignHorarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
