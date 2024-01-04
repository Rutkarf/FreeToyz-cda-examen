import { TestBed } from '@angular/core/testing';

import { ToyzsBySearchService } from './toyzs-by-search.service';

describe('ToyzsBySearchService', () => {
  let service: ToyzsBySearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ToyzsBySearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
