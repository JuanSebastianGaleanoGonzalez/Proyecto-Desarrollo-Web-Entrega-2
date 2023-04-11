import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaCreateComponent } from './ruta-create.component';

describe('RutaCreateComponent', () => {
  let component: RutaCreateComponent;
  let fixture: ComponentFixture<RutaCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutaCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
