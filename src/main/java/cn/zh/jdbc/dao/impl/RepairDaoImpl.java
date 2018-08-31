package cn.zh.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.RepairDao;
import cn.zh.jdbc.domain.Repair;

@Repository
public class RepairDaoImpl implements RepairDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int update(Repair repair) {
		return jdbcTemplate.update("UPDATE repair SET traction_machine=? ,room_environment=? ,encoder=?,"
					+ "brakespinparts=? ,brakesclearance=?,speedlimiter=?,operating_device=?,"
					+ "car_wing=?,car_door=?,show_wing=?,floor_wing=?,emergency_alarm=?,sentinel_plant=?,weigh=?,"
					+ "tank_guide_rail=?,button_plate=?,top_emergency_device=?,top_lubrication=?,top_vibration=?,"
					+ "houta_hall=?,gate_check=?,gate_operation=?,gate_interlocking=?,well_cable=?,limit_speed_switch=?,door_plank=?,"
					+ "light=?,sudden_stop_switch=?,rovolve_member=?,pond=? WHERE user_number=?",
					repair.getTranction_machine(),repair.getRoom_environment(),repair.getEncoder(),
					repair.getBrakespinparts(),repair.getBrakesclearance(),repair.getSpeedlimiter(),repair.getOperating_device(),
					repair.getCar_wing(),repair.getCar_door(),repair.getShow(),repair.getFloor(),repair.getEmergency_alarm(),repair.getSentinel_plant(),
					repair.getWeigh(),repair.getTank_guide_rail(),repair.getButton_plate(),repair.getTop_emergency_device(),repair.getTop_lubrication(),repair.getTop_vibration(),
					repair.getHouta_hall(),repair.getGate_check(),repair.getGate_operation(),repair.getGate_interlocking(),repair.getWell_cable(),repair.getLimit_speed_switch(),
					repair.getDoor_plank(),repair.getLight(),repair.getSudden_stop_switch(),repair.getRovolve_member(),repair.getPond()
					,repair.getUser_number()
					);
	}

}
