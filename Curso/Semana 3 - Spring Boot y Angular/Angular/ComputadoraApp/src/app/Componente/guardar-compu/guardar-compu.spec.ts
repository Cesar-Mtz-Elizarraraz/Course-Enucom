import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarCompu } from './guardar-compu';

describe('GuardarCompu', () => {
  let component: GuardarCompu;
  let fixture: ComponentFixture<GuardarCompu>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarCompu]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarCompu);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
