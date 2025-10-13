import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarV } from './listar-v';

describe('ListarV', () => {
  let component: ListarV;
  let fixture: ComponentFixture<ListarV>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarV]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarV);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
