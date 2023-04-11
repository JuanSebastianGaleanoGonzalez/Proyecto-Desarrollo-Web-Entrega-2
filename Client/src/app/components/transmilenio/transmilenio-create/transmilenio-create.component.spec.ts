import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransmilenioCreateComponent } from './transmilenio-create.component';

describe('TransmilenioCreateComponent', () => {
  let component: TransmilenioCreateComponent;
  let fixture: ComponentFixture<TransmilenioCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransmilenioCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransmilenioCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
