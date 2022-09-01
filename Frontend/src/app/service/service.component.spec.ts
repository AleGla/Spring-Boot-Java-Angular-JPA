import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceService } from './service.component';


describe('ServiceComponent', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ServiceService = TestBed.get(ServiceService);
    expect(service).toBeTruthy();
  });
});
