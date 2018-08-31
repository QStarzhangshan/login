package cn.zh.jdbc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.IndexDao;
import cn.zh.jdbc.domain.ElevatorNumber;
import cn.zh.jdbc.domain.ElevatorRate;
import cn.zh.jdbc.domain.FaultyElevator;
import cn.zh.jdbc.domain.MaintenanceElevator;
import cn.zh.jdbc.domain.MaintenanceStaff;
import cn.zh.jdbc.service.IndexService;
@Service
public class IndexServiceImpl implements IndexService{

	@Autowired
	IndexDao indexDao;
	
	@Override
	public Map<String, String> getindex() {
		return indexDao.getindex(); 
	}

	@Override
	public List<MaintenanceElevator> getmaintenanceElevator(String city) {
		return indexDao.getmaintenanceElevator(city);
	}

	@Override
	public String getmaintenanceNmuber(String task_time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaultyElevator> getfaultyelevator(String city) {
		return indexDao.getfaultyelevator(city);
	}

	@Override
	public List<MaintenanceStaff> getmaintenancestaff(String city) {
		return indexDao.getmaintenancestaff(city);
	}

	@Override
	public List<ElevatorRate> getelevatornumber(String city) {
		return indexDao.getelevatornumber(city);
	}

	

}
