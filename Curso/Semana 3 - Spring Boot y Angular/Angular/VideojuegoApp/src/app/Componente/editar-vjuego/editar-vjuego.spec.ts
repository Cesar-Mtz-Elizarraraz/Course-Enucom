import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarVJuego } from './editar-vjuego';

describe('EditarVJuego', () => {
  let component: EditarVJuego;
  let fixture: ComponentFixture<EditarVJuego>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarVJuego]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarVJuego);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
