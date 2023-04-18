import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransmilenioAsignConductorComponent } from './transmilenio-asign-conductor.component';

describe('TransmilenioAsignConductorComponent', () => {
  let component: TransmilenioAsignConductorComponent;
  let fixture: ComponentFixture<TransmilenioAsignConductorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransmilenioAsignConductorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransmilenioAsignConductorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
