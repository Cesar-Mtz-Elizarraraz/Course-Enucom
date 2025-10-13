import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarV } from './guardar-v';

describe('GuardarV', () => {
  let component: GuardarV;
  let fixture: ComponentFixture<GuardarV>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarV]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarV);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
