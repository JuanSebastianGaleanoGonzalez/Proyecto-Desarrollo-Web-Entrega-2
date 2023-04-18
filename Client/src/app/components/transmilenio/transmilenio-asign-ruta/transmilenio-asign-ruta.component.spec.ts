import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransmilenioAsignRutaComponent } from './transmilenio-asign-ruta.component';

describe('TransmilenioAsignRutaComponent', () => {
  let component: TransmilenioAsignRutaComponent;
  let fixture: ComponentFixture<TransmilenioAsignRutaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransmilenioAsignRutaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransmilenioAsignRutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
