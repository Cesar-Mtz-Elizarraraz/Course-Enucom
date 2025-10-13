import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCli } from './listar-cli';

describe('ListarCli', () => {
  let component: ListarCli;
  let fixture: ComponentFixture<ListarCli>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCli]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCli);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
