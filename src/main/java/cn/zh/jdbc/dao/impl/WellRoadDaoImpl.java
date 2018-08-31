package cn.zh.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cn.zh.jdbc.dao.WellRoadDao;
import cn.zh.jdbc.domain.CarWing;
import cn.zh.jdbc.domain.WellRoad;

@Repository
public class WellRoadDaoImpl implements WellRoadDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int update(WellRoad wellRoad) {
		return jdbcTemplate.update("UPDATE well_road SET houta_hall=?,gate_check=?,gate_operation=?,gate_interlocking=?,well_cable=?,limit_speed_switch=?,door_plank=? "
				+ "WHERE service_id=?",
				wellRoad.getHouta_hall(),wellRoad.getGate_check(),wellRoad.getGate_operation(),wellRoad.getGate_interlocking(),wellRoad.getWell_cable(),wellRoad.getLimit_speed_switch(),
				wellRoad.getDoor_plank(),wellRoad.getService_id());
	}

}
