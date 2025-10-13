import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarC } from './listar-c';

describe('ListarC', () => {
  let component: ListarC;
  let fixture: ComponentFixture<ListarC>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarC]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarC);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
