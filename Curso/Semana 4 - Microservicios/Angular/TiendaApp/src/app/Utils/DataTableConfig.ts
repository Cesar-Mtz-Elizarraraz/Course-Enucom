import DataTable, { ConfigColumnDefs } from "datatables.net-dt";

export class DataTableConfig {

    initDataTable(dataTable: any, tableId: String, columnsDefs?: ConfigColumnDefs[]){
    dataTable = new DataTable(`#${tableId}`, {
        pageLength: 10,
        lengthMenu: [5, 10, 25, 50],
        ordering: true,
        order: [[0, 'asc']],
        searching: true,
        destroy: true,
        autoWidth: false,
        language: {
          "emptyTable": "No hay datos disponibles en la tabla",
          "info": "Mostrando _START_ a _END_ de _TOTAL_ registros",
          "infoEmpty": "Mostrando 0 a 0 de 0 registros",
          "infoFiltered": "(filtrado de _MAX_ registros totales)",
          "lengthMenu": "Mostrar _MENU_ registros",
          "loadingRecords": "Cargando...",
          "processing": "Procesando...",
          "search": "Buscar:",
          "zeroRecords": "No se encontraron resultados",
        },
        columnDefs: columnsDefs
    });
    return dataTable
  }
} 