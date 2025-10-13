import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarL } from './listar-l';

describe('ListarL', () => {
  let component: ListarL;
  let fixture: ComponentFixture<ListarL>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarL]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarL);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
