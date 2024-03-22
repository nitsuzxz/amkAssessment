import { User } from '../models/user-model';
import { Status } from '../models/status-model';

export interface Timesheet {
    timesheet: {
      timesheetID: number;
      project: string;
      task: string;
      dateFrom: Date;
      dateTo: Date;
      statusID: number;
      user: number;
    };
    user: User;
    status: Status;
  }

