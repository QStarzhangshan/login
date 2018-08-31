package cn.zh.jdbc.dao;

import java.util.List;
import java.util.Map;

import cn.zh.jdbc.domain.ElevatorNumber;
import cn.zh.jdbc.domain.ElevatorRate;
import cn.zh.jdbc.domain.FaultyElevator;
import cn.zh.jdbc.domain.MaintenanceElevator;
import cn.zh.jdbc.domain.MaintenanceStaff;

public interface IndexDao {

	Map<String, String> getindex();

	List<MaintenanceElevator> getmaintenanceElevator(String city);

	String getmaintenanceNumber(String task_time);

	List<FaultyElevator> getfaultyelevator(String city);

	List<MaintenanceStaff> getmaintenancestaff(String city);

	List<ElevatorRate> getelevatornumber(String city);

}
