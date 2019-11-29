import { TestBed } from '@angular/core/testing';

import { CuentasRestService } from './cuentas-rest.service';

describe('CuentasRestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CuentasRestService = TestBed.get(CuentasRestService);
    expect(service).toBeTruthy();
  });
});
