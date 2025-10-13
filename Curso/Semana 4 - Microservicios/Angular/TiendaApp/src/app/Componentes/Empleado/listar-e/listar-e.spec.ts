import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarE } from './listar-e';

describe('ListarE', () => {
  let component: ListarE;
  let fixture: ComponentFixture<ListarE>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarE]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarE);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
