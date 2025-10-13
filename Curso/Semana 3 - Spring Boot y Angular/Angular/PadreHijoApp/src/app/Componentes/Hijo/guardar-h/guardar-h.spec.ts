import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarH } from './guardar-h';

describe('GuardarH', () => {
  let component: GuardarH;
  let fixture: ComponentFixture<GuardarH>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarH]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarH);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
