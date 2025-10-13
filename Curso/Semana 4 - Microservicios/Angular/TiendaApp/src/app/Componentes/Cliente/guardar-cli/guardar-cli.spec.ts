import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuardarCli } from './guardar-cli';

describe('GuardarCli', () => {
  let component: GuardarCli;
  let fixture: ComponentFixture<GuardarCli>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GuardarCli]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GuardarCli);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
