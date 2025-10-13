import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarH } from './listar-h';

describe('ListarH', () => {
  let component: ListarH;
  let fixture: ComponentFixture<ListarH>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarH]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarH);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
