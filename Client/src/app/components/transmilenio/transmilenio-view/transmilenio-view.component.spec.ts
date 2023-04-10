import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransmilenioViewComponent } from './transmilenio-view.component';

describe('TransmilenioViewComponent', () => {
  let component: TransmilenioViewComponent;
  let fixture: ComponentFixture<TransmilenioViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransmilenioViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransmilenioViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
