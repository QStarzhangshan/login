package cn.zh.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.CarWingDao;
import cn.zh.jdbc.domain.CarWing;

@Repository
public class CarWingDaoImpl implements CarWingDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int update(CarWing carWing) {
		return jdbcTemplate.update("UPDATE car_wing SET car_wing=?,car_door=?,show_wing=?,floor_wing=?,emergency_alarm=?,sentinel_plant=?,weigh=?"
				+ ",tank_guide_rail=?,button_plate=?,top_emergency_device=?,top_lubrication=?,top_vibration=? WHERE service_id=?",
				carWing.getCar_wing(),carWing.getCar_door(),carWing.getShow(),carWing.getFloor(),carWing.getEmergency_alarm(),carWing.getSentinel_plant(),
				carWing.getWeigh(),carWing.getTank_guide_rail(),carWing.getButton_plate(),carWing.getTop_emergency_device(),carWing.getTop_lubrication(),carWing.getTop_vibration(),
				carWing.getService_id());
	}

}
