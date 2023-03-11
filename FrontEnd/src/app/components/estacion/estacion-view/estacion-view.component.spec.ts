import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstacionViewComponent } from './estacion-view.component';

describe('EstacionViewComponent', () => {
  let component: EstacionViewComponent;
  let fixture: ComponentFixture<EstacionViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstacionViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstacionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
