import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarR } from './listar-r';

describe('ListarR', () => {
  let component: ListarR;
  let fixture: ComponentFixture<ListarR>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarR]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarR);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
