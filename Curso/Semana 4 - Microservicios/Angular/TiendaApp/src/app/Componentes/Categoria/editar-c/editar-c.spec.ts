import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarC } from './editar-c';

describe('EditarC', () => {
  let component: EditarC;
  let fixture: ComponentFixture<EditarC>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarC]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarC);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
