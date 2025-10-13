import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarM } from './listar-m';

describe('ListarM', () => {
  let component: ListarM;
  let fixture: ComponentFixture<ListarM>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarM]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarM);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
