import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-entry-details',
  templateUrl: './entryDetails.component.html',
  styleUrls: ['./entryDetails.component.less']
})
export class EntryDetailsComponent implements OnInit {

  // input
  _options: any;

  fieldsList: any = [];
  formEntry: any = {};
  displayDialog: boolean;

  @Output() onDialogTakeAction = new EventEmitter<any>();
  @Output() onAdd = new EventEmitter<any>();
  @Output() onEdit = new EventEmitter<any>();
  @Output() onDelete = new EventEmitter<any>();

  constructor() { }

  ngOnInit() {
  }

  @Input() set options(options: any) {
    this._options = options;
  }

  showDialog(formEntry: any, fieldsList: any) {
    this.fieldsList = fieldsList;
    this.formEntry = formEntry;
    this.displayDialog = true;
  }

  dialogTakeAction() {
    if (typeof this.formEntry.id === 'undefined') {
      this.onAdd.emit(this.formEntry);
    } else {
      this.onEdit.emit(this.formEntry);
    }
    this.displayDialog = false;
  }

}
