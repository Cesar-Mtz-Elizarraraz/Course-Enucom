import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarVJuego } from './listar-vjuego';

describe('ListarVJuego', () => {
  let component: ListarVJuego;
  let fixture: ComponentFixture<ListarVJuego>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarVJuego]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarVJuego);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
