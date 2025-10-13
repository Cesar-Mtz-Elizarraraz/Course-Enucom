import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarA } from './editar-a';

describe('EditarA', () => {
  let component: EditarA;
  let fixture: ComponentFixture<EditarA>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarA]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarA);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
