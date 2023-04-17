import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConductorAsignComponent } from './conductor-asign.component';

describe('ConductorAsignComponent', () => {
  let component: ConductorAsignComponent;
  let fixture: ComponentFixture<ConductorAsignComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConductorAsignComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConductorAsignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
