import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarCli } from './editar-cli';

describe('EditarCli', () => {
  let component: EditarCli;
  let fixture: ComponentFixture<EditarCli>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarCli]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarCli);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
