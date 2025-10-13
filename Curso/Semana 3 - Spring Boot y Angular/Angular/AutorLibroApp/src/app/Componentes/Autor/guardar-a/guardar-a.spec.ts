import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarA } from './guardar-a';

describe('GuardarA', () => {
  let component: GuardarA;
  let fixture: ComponentFixture<GuardarA>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarA]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarA);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
