import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BusquedaLocalComponent } from './busqueda-local.component';

describe('BusquedaLocalComponent', () => {
  let component: BusquedaLocalComponent;
  let fixture: ComponentFixture<BusquedaLocalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BusquedaLocalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BusquedaLocalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
