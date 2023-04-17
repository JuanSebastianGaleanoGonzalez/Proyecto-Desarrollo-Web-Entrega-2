import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaAsignTransmilenioComponent } from './ruta-asign-transmilenio.component';

describe('RutaAsignTransmilenioComponent', () => {
  let component: RutaAsignTransmilenioComponent;
  let fixture: ComponentFixture<RutaAsignTransmilenioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutaAsignTransmilenioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaAsignTransmilenioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
