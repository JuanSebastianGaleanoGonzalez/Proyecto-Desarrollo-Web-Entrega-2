import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaViewComponent } from './ruta-view.component';

describe('RutaViewComponent', () => {
  let component: RutaViewComponent;
  let fixture: ComponentFixture<RutaViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutaViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
