import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarM } from './guardar-m';

describe('GuardarM', () => {
  let component: GuardarM;
  let fixture: ComponentFixture<GuardarM>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarM]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarM);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
