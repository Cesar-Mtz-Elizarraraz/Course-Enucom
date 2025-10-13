import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarE } from './guardar-e';

describe('GuardarE', () => {
  let component: GuardarE;
  let fixture: ComponentFixture<GuardarE>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarE]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarE);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
