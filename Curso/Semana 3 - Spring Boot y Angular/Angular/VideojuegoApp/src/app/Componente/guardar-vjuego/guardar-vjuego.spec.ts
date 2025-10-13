import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarVJuego } from './guardar-vjuego';

describe('GuardarVJuego', () => {
  let component: GuardarVJuego;
  let fixture: ComponentFixture<GuardarVJuego>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarVJuego]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarVJuego);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
