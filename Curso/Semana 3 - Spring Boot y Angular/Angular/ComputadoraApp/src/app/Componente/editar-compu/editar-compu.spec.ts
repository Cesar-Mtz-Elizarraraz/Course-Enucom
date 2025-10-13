import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarCompu } from './editar-compu';

describe('EditarCompu', () => {
  let component: EditarCompu;
  let fixture: ComponentFixture<EditarCompu>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarCompu]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarCompu);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
