import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformationTable } from './information-table';

describe('InformationTable', () => {
  let component: InformationTable;
  let fixture: ComponentFixture<InformationTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InformationTable]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InformationTable);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
