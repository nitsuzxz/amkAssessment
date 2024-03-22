import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Timesheet } from '../models/timesheet-model';
import { User } from '../models/user-model';
import { Status } from '../models/status-model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = 'http://localhost:8084/api/v1'; 

  constructor(private http: HttpClient) { }

  fetchTimesheet(): Observable<Timesheet[]> {
    return this.http.get<Timesheet[]>(`${this.apiUrl}/timesheet/all`);
  }

  fetchAllUser(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/user/getAllUser`);
  }

  fetchAllStatus(): Observable<Status[]> {
    return this.http.get<Status[]>(`${this.apiUrl}/status/getStatus`);
  }

  insertTimesheet(timesheetData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/timesheet/insertTimesheet`, timesheetData);
  }

  updateTimesheet(timesheetData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/timesheet/updateTimesheet`, timesheetData);
  }

  deleteTimesheet(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/timesheet/deleteTimesheet/${id}`);
  }

}
