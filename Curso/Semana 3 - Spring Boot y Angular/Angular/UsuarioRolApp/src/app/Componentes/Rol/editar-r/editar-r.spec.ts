import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarR } from './editar-r';

describe('EditarR', () => {
  let component: EditarR;
  let fixture: ComponentFixture<EditarR>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarR]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarR);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
