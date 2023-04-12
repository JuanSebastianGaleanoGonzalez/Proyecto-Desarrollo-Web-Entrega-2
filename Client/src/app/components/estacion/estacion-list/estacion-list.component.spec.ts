import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstacionListComponent } from './estacion-list.component';

describe('EstacionListComponent', () => {
  let component: EstacionListComponent;
  let fixture: ComponentFixture<EstacionListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstacionListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EstacionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
