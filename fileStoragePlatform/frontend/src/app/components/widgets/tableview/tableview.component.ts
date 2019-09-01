import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { SelectItem } from 'primeng/primeng';
import { RepeatPipe } from 'ng-pipes';

@Component({
  selector: 'app-tableview',
  templateUrl: './tableview.component.html',
  styleUrls: ['./tableview.component.less'],
  providers: [RepeatPipe]
})

export class TableViewComponent implements OnInit {
  // input
  _tableInput: any;
  _options: any;

  // core
  mapper: Mapper = new Mapper();
  tableCols: any[];
  tableValues: any[];
  columnOptions: SelectItem[];

  // EventEmitter
  @Output() onAddRow = new EventEmitter<any>();
  @Output() onViewRow = new EventEmitter<any>();
  @Output() onEditRow = new EventEmitter<any>();
  @Output() onDeleteRow = new EventEmitter<any>();

  constructor() { }

  ngOnInit() {
    if (this._options.tableColumns) {
      this.tableCols = this._options.tableColumns;
    } else {
      this.tableCols = this.mapper.getColumns(this.tableValues[0]);
    }
    this._options.hideColumn.forEach(element => {
      this.tableCols = this.tableCols.filter((val) => val.header !== element);
    });
    this.columnOptions = this.mapper.getToggleCols(this.tableCols);
  }

  @Input() set tableInput(tableInput: any) {
    this.tableValues = tableInput;
  }

  @Input() set options(options: any) {
    this._options = options;
  }

  /**
   * Add a row to the table
   *
   * @param {*} row
   * @memberof TableViewComponent
   */
  addElementToTable(row: any) {
    const tmp = [...this.tableValues];
    tmp.push(row);
    this.tableValues = tmp;
  }

  /**
   * Emit add row event
   *
   * @memberof TableViewComponent
   */
  addRow(row: any) {
    this.onAddRow.emit(row);
  }

  /**
   * Emit selected row for view event`
   *
   * @param {*} row
   * @memberof TableViewComponent
   */
  viewRow(row: any) {
    this.onViewRow.emit(row);
  }

  /**
   * Emit selected row for edit event
   *
   * @param {*} row
   * @memberof TableViewComponent
   */
  editRow(row: any) {
    this.onEditRow.emit(row);
  }

  /**
   * Emit selected row for delete event
   *
   * @param {*} row
   * @memberof TableViewComponent
   */
  deleteRow(row: any) {
    this.tableValues = this.tableValues.filter((val, i) => i !== this.tableValues.indexOf(row));
    this.onDeleteRow.emit(row);
  }

}

class Mapper {
  /**
   * Creates an instance of Mapper.
   * @memberof Mapper
   */
  constructor() { }

  /**
 * Get columns model from a row response
 *
 * @param {*} row
 * @returns {any[]}
 * @memberof TableViewComponent
 */
  getColumns(row: any): any[] {
    const cols: any[] = [];
    for (const key in row) {
      if (row.hasOwnProperty(key)) {
        const col = {
          field: key,
          header: key
        };
        cols.push(col);
      }
    }
    return cols;
  }

  /**
   * Get toggle columns option
   *
   * @param {*} tableCols
   * @returns {any[]}
   * @memberof TableViewComponent
   */
  getToggleCols(tableCols: any): any[] {
    const columnOptions: SelectItem[] = [];
    tableCols.forEach(element => {
      columnOptions.push({ label: element.header, value: element });
    });
    return columnOptions;
  }
}
