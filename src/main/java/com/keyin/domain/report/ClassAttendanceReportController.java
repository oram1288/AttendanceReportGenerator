package com.keyin.domain.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ClassAttendanceReportController {
    @Autowired
    private ClassAttendanceReportService classAttendanceReportService;

    @GetMapping("attendance_report")
    public ClassAttendanceReport cgenerateClassAttendanceReport(@RequestParam long courseClassId) {
        return classAttendanceReportService.createClassAttendanceReport(courseClassId);
    }
}
