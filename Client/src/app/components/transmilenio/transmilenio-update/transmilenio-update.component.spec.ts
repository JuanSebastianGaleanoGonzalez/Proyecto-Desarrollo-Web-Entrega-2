import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransmilenioUpdateComponent } from './transmilenio-update.component';

describe('TransmilenioUpdateComponent', () => {
  let component: TransmilenioUpdateComponent;
  let fixture: ComponentFixture<TransmilenioUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransmilenioUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransmilenioUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
