import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarV } from './editar-v';

describe('EditarV', () => {
  let component: EditarV;
  let fixture: ComponentFixture<EditarV>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarV]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarV);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
