import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConductorUpdateComponent } from './conductor-update.component';

describe('ConductorUpdateComponent', () => {
  let component: ConductorUpdateComponent;
  let fixture: ComponentFixture<ConductorUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConductorUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConductorUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
