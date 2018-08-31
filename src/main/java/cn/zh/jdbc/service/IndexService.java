package cn.zh.jdbc.service;

import java.util.List;
import java.util.Map;

import cn.zh.jdbc.domain.ElevatorNumber;
import cn.zh.jdbc.domain.ElevatorRate;
import cn.zh.jdbc.domain.FaultyElevator;
import cn.zh.jdbc.domain.Index;
import cn.zh.jdbc.domain.MaintenanceElevator;
import cn.zh.jdbc.domain.MaintenanceStaff;

public interface IndexService {

	Map<String,String> getindex();

	List<MaintenanceElevator> getmaintenanceElevator(String city);

	String getmaintenanceNmuber(String task_time);

	List<FaultyElevator> getfaultyelevator(String city);

	List<MaintenanceStaff> getmaintenancestaff(String city);

	List<ElevatorRate> getelevatornumber(String city);

}
