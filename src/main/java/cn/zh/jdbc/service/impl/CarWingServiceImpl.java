package cn.zh.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.CarWingDao;
import cn.zh.jdbc.domain.CarWing;
import cn.zh.jdbc.service.CarWingService;

@Service
public class CarWingServiceImpl implements CarWingService{

	@Autowired
	private CarWingDao carWingDao;

	@Override
	public int update(CarWing carWing) {
		// TODO Auto-generated method stub
		return carWingDao.update(carWing);
	}
	
	
	
	
	
}
