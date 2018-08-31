package cn.zh.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.WellRoadDao;
import cn.zh.jdbc.domain.CarWing;
import cn.zh.jdbc.domain.WellRoad;
import cn.zh.jdbc.service.WellRoadService;

@Service
public class WellRoadServiceImpl implements WellRoadService{

	@Autowired
	private WellRoadDao wellRoadDao;

	@Override
	public int update(WellRoad wellRoad) {
		// TODO Auto-generated method stub
		return wellRoadDao.update(wellRoad);
	}
	
	
	
	
	
}
