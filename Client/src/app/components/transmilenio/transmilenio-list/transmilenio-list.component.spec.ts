import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransmilenioListComponent } from './transmilenio-list.component';

describe('TransmilenioListComponent', () => {
  let component: TransmilenioListComponent;
  let fixture: ComponentFixture<TransmilenioListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransmilenioListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransmilenioListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
