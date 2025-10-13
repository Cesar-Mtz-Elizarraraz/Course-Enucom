import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarA } from './listar-a';

describe('ListarA', () => {
  let component: ListarA;
  let fixture: ComponentFixture<ListarA>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarA]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarA);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
