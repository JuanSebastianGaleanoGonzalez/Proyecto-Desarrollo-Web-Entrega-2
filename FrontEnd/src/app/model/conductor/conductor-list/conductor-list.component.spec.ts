import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConductorListComponent } from './conductor-list.component';

describe('ConductorListComponent', () => {
  let component: ConductorListComponent;
  let fixture: ComponentFixture<ConductorListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConductorListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConductorListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
