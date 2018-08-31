package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.LocationDao;
import cn.zh.jdbc.domain.ClientByMap;
import cn.zh.jdbc.domain.Location;
import cn.zh.jdbc.domain.MaintenanceByMap;
import cn.zh.jdbc.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao locationDao;
	
	@Override
	public List<Location> getLocation() {
		// TODO Auto-generated method stub
		return locationDao.getLocation();
	}

	@Override
	public List<ClientByMap> getinfobyMap() {
		return locationDao.getinfoByMap();
	}

	@Override
	public List<ClientByMap> getclientbymap() {
		return locationDao.getclientbymap();
	}

	@Override
	public List<MaintenanceByMap> getmaintenancebymap() {
		return locationDao.getmaintenancebymap();
	}

}
