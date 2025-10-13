import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarP } from './editar-p';

describe('EditarP', () => {
  let component: EditarP;
  let fixture: ComponentFixture<EditarP>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarP]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarP);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
