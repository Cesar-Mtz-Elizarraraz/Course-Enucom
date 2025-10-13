import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarC } from './guardar-c';

describe('GuardarC', () => {
  let component: GuardarC;
  let fixture: ComponentFixture<GuardarC>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarC]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarC);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
