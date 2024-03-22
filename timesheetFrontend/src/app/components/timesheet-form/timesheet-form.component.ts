import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { ApiService } from '../../service/api.service';
import { HttpClientModule } from '@angular/common/http';
import {
  ReactiveFormsModule,
  FormGroup,
  FormBuilder,
  Validators,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MessageModule } from 'primeng/message';

@Component({
  selector: 'app-timesheet-form',
  standalone: true,
  imports: [
    DialogModule,
    InputTextModule,
    CalendarModule,
    DropdownModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    MessageModule,
  ],
  templateUrl: './timesheet-form.component.html',
  styleUrls: ['./timesheet-form.component.css'],
})
export class TimesheetFormComponent implements OnInit, OnChanges {
  taskInput: string = '';
  projectInput: string = '';
  listStatus: any;
  listUser: any;
  timesheetForm: FormGroup;
  updateMode: boolean = false;
  formTitle: string = 'Timesheet Entry';
  timesheetID: number | null = null;

  @Input() showModal: boolean = false;
  @Input() updateTimesheetData: any;
  @Output() closeModal: EventEmitter<void> = new EventEmitter<void>();

  constructor(private apiService: ApiService, private fb: FormBuilder) {
    this.timesheetForm = this.fb.group({
      project: ['', Validators.required],
      task: ['', Validators.required],
      dateFrom: [null, Validators.required],
      dateTo: [null, Validators.required],
      status: ['', Validators.required],
      assignTo: [''],
    });

    this.timesheetForm.get('status')!.valueChanges.subscribe((value) => {
      if (value !== 1) {
        this.timesheetForm
          .get('assignTo')!
          .setValidators([Validators.required]);
      } else {
        this.timesheetForm.get('assignTo')!.clearValidators();
      }
      this.timesheetForm.get('assignTo')!.updateValueAndValidity();
    });
  }

  ngOnInit(): void {
    this.fetchAllStatus();
    this.fetchAllUser();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['updateTimesheetData']) {
      const newData = changes['updateTimesheetData'].currentValue;
      if (newData) {
        this.updateMode = true;
        this.formTitle = 'Update Timesheet Entry';
        const dateFrom = new Date(newData.timesheet.dateFrom);
        const dateTo = new Date(newData.timesheet.dateTo);
        this.timesheetID=newData.timesheet.timesheetID;
        this.timesheetForm.get('project')?.setValue(newData.timesheet.project);
        this.timesheetForm.get('task')?.setValue(newData.timesheet.task);
        this.timesheetForm.get('dateFrom')?.setValue(dateFrom);
        this.timesheetForm.get('dateTo')?.setValue(dateTo);
        this.timesheetForm.get('status')?.setValue(newData.timesheet.statusID);
        this.timesheetForm.get('assignTo')?.setValue(newData.timesheet.userID);
      }
    }
  }

  fetchAllStatus(): void {
    this.apiService.fetchAllStatus().subscribe((response) => {
      this.listStatus = response;
    });
  }

  fetchAllUser(): void {
    this.apiService.fetchAllUser().subscribe((response) => {
      this.listUser = response;
    });
  }

  onCloseModal() {
    this.updateMode = false;
    this.formTitle = 'Timesheet Entry';
    this.timesheetForm.reset();
    this.closeModal.emit();
  }

  saveTimesheet() {
    Object.values(this.timesheetForm.controls).forEach((control) => {
      control.markAsTouched();
    });

    

    if (this.timesheetForm.valid) {
      if (this.updateMode === true) {
        console.log(true);
        const timesheetData = {
          timesheetID: this.timesheetID,
          project: this.timesheetForm.value.project,
          task: this.timesheetForm.value.task,
          userID: this.timesheetForm.value.assignTo,
          dateFrom: this.timesheetForm.value.dateFrom,
          dateTo: this.timesheetForm.value.dateTo,
          statusID: this.timesheetForm.value.status,
        };

        console.log(JSON.stringify(timesheetData));
        this.apiService.updateTimesheet(timesheetData).subscribe(
          () => this.onCloseModal(),
          (error) =>
            console.error('Error occurred while update timesheet', error)
        );
      } else {
        console.log(false);
        const timesheetData = {
          project: this.timesheetForm.value.project,
          task: this.timesheetForm.value.task,
          userID: this.timesheetForm.value.assignTo,
          dateFrom: this.timesheetForm.value.dateFrom,
          dateTo: this.timesheetForm.value.dateTo,
          statusID: this.timesheetForm.value.status,
        };
        this.apiService.insertTimesheet(timesheetData).subscribe(
          () => this.onCloseModal(),
          (error) =>
            console.error('Error occurred while inserting timesheet', error)
        );
      }
    }
  }
}
