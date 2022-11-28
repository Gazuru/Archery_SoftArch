import {TestBed} from '@angular/core/testing';

import {BowService} from './bow.service';

describe('BowService', () => {
  let service: BowService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BowService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
