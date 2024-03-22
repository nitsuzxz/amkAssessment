package com.ikhmal.timesheet.Repo;

import com.ikhmal.timesheet.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface TimesheetRepo extends JpaRepository<Timesheet, Integer> {
    @Query("SELECT t, u, s FROM Timesheet t JOIN User u ON t.userID = u.userID JOIN Status s ON t.statusID = s.statusID ORDER BY t.timesheetID DESC")

    List<Object[]> findAllTimesheetsWithUserAndStatus();


}