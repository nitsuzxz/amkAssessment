import { Component, OnInit } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { FormsModule } from '@angular/forms';
import { ApiService } from './service/api.service';
import { HttpClientModule } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { TimesheetFormComponent } from './components/timesheet-form/timesheet-form.component';

interface Column {
  field: string;
  header: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [
    InputTextModule,
    ButtonModule,
    FormsModule,
    HttpClientModule,
    TableModule,
    CommonModule,
    TimesheetFormComponent,
  ],
})
export class AppComponent implements OnInit {
  title = 'timesheetFrontend';
  searchTask: string = '';
  showTimesheetForm: boolean = false;
  timesheetData: any;
  updateData: any;
  filteredTimesheetData: any;
  cols!: Column[];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.fetchTimesheet();
  }

  fetchTimesheet(): void {
    this.apiService.fetchTimesheet().subscribe((response) => {
      this.timesheetData = response;
      this.filteredTimesheetData = this.timesheetData;
      this.cols = [
        { field: 'timesheet.project', header: 'Project' },
        { field: 'timesheet.task', header: 'Task' },
        { field: 'timesheet.dateFrom', header: 'From' },
        { field: 'timesheet.dateTo', header: 'To' },
        { field: 'user.name', header: 'Name' },
        { field: 'status.statusDescription', header: 'Status' },
        { field: 'timesheet.timesheetid', header: '' },
      ];
    });
  }

  openTimesheetForm(open: boolean) {
    this.showTimesheetForm = open;
  }

  updateTimesheet(open: boolean, data: any) {
    this.showTimesheetForm = open;
    this.updateData = data;
  }

  closeModal() {
    this.showTimesheetForm = false;
    this.fetchTimesheet();
  }

  deleteTimesheet(id: number): void {
    this.apiService.deleteTimesheet(id).subscribe(
      () => {
        console.log('Timesheet deleted successfully');
        this.fetchTimesheet();
      },
      (error) => {
        console.error('Error occurred while deleting timesheet', error);
      }
    );
  }
  
  filterData() {
    if (!this.searchTask) {
      this.filteredTimesheetData = this.timesheetData;
      return;
    }

    this.filteredTimesheetData = this.timesheetData.filter((item: any) =>
      item.timesheet.task.toLowerCase().includes(this.searchTask.toLowerCase())
    );
  }
}
