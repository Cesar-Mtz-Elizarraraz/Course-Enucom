import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarH } from './editar-h';

describe('EditarH', () => {
  let component: EditarH;
  let fixture: ComponentFixture<EditarH>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarH]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarH);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
