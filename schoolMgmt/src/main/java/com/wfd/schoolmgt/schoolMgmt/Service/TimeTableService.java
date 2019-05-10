package com.wfd.schoolmgt.schoolMgmt.Service;

import com.wfd.schoolmgt.schoolMgmt.Entity.TimeTable;

public interface TimeTableService  {

	TimeTable createTimeTable(TimeTable pTimeTable);

	TimeTable getTimeTable(Integer timeTableId);

	TimeTable updateTimeTable(TimeTable pTimeTable);

	String deleteTimeTable(Integer timeTableId);

}
