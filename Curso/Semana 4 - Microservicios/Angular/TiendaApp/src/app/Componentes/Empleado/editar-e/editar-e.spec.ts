import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarE } from './editar-e';

describe('EditarE', () => {
  let component: EditarE;
  let fixture: ComponentFixture<EditarE>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarE]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarE);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
