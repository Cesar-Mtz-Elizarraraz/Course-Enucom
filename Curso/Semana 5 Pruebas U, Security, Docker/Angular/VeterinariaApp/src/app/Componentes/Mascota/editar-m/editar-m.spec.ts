import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarM } from './editar-m';

describe('EditarM', () => {
  let component: EditarM;
  let fixture: ComponentFixture<EditarM>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarM]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarM);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
