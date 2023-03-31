import { TestBed } from '@angular/core/testing';

import { TransmilenioService } from './transmilenio.service';

describe('TransmilenioService', () => {
  let service: TransmilenioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransmilenioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
