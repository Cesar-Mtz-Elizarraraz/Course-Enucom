import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCompu } from './listar-compu';

describe('ListarCompu', () => {
  let component: ListarCompu;
  let fixture: ComponentFixture<ListarCompu>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCompu]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCompu);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
