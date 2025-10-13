import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarL } from './guardar-l';

describe('GuardarL', () => {
  let component: GuardarL;
  let fixture: ComponentFixture<GuardarL>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarL]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarL);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
