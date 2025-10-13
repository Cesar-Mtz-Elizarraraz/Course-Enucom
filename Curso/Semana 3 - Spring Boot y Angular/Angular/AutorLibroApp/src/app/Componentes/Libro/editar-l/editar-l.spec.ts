import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarL } from './editar-l';

describe('EditarL', () => {
  let component: EditarL;
  let fixture: ComponentFixture<EditarL>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarL]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarL);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
