import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaUpdateComponent } from './ruta-update.component';

describe('RutaUpdateComponent', () => {
  let component: RutaUpdateComponent;
  let fixture: ComponentFixture<RutaUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutaUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
