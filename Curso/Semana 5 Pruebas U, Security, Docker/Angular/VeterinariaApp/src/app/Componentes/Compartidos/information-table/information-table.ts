import { Component, EventEmitter, Input, Output, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faTrashCan, faPen } from '@fortawesome/free-solid-svg-icons';
import { DatatableComponent, NgxDatatableModule } from '@swimlane/ngx-datatable';
import { InformationTableConfig } from '../../../Interfaces/InformationTableConfig';


@Component({
  selector: 'app-information-table',
  imports: [FormsModule, NgxDatatableModule, FontAwesomeModule],
  templateUrl: './information-table.html',
  styleUrl: './information-table.css'
})
export class InformationTable {

  @ViewChild(DatatableComponent) table!: DatatableComponent<any>;
  
  private _rows: any[] = [];
  rowsTemp: any[] = [];
  selectedLimit: string = '10';

  @Input() tableConfig !: InformationTableConfig;
  @Input() withActions !: boolean;

  @Input()
  set rows(value: any[]) {
    this._rows = value || [];
    this.rowsTemp = [...this._rows];
  }

  get rows(): any[] {
    return this._rows;
  }

  @Output() editar = new EventEmitter<number>();
  @Output() eliminar = new EventEmitter<number>(); 

  faTrasCan = faTrashCan
  faPen = faPen

  opciones = [
    { valor: '5', texto: '5' },
    { valor: '10', texto: '10' },
    { valor: '50', texto: '50' },
    { valor: '100', texto: '100' }
  ];

  filterRows(event: KeyboardEvent) {
    const val = (event.target as HTMLInputElement).value.toLowerCase();

    /*this.rows = this.rowsTemp.filter((d) => {
      const term = val.toLocaleString().toLowerCase();
      return (
        d.nombre.toLowerCase().includes(term) ||
        d.direccion.toLowerCase().includes(term) ||
        d.contacto.toString().includes(term) ||
        !term
      );
    });*/

    this.rowsTemp = this._rows.filter((row) => {
      const term = val.toLocaleString().toLowerCase();
      return (
        !term || 
        Object.values(row).some((field) =>
          field?.toString().toLowerCase().includes(term)
        )
      );
    });

    this.table.offset = 0;
  }
}
