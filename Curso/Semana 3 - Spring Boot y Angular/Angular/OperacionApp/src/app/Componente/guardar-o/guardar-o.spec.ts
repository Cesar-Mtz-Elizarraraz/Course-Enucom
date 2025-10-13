import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarO } from './guardar-o';

describe('GuardarO', () => {
  let component: GuardarO;
  let fixture: ComponentFixture<GuardarO>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarO]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarO);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
