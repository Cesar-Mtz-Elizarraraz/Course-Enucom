import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarR } from './guardar-r';

describe('GuardarR', () => {
  let component: GuardarR;
  let fixture: ComponentFixture<GuardarR>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarR]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarR);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
