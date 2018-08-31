package cn.zh.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.IndexDao;
import cn.zh.jdbc.domain.ElevatorRate;
import cn.zh.jdbc.domain.FaultyElevator;
import cn.zh.jdbc.domain.MaintenanceElevator;
import cn.zh.jdbc.domain.MaintenanceStaff;
@Repository
public class IndexDaoImpl implements IndexDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, String> getindex() {
		return null;
	}

	@Override
	public List<MaintenanceElevator> getmaintenanceElevator(String city) {
		String str;
		if(city==null || city=="") {
			str = "";
		}else {
			str = "WHERE sys_task.city="+city+"";
		}
		
		String sql = "SELECT " + 
				"DATE(dday) maintenance_date, " + 
				"COUNT(*) - 1 AS maintenance_count " + 
				"FROM " + 
				" ( " + 
				"  SELECT " + 
				"      datelist AS dday " + 
				"        FROM " + 
				"       calendar " + 
				"            WHERE  DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(datelist)&&DATE(datelist)<=CURDATE() " + 
				"        UNION ALL " + 
				"            SELECT " + 
				"                task_createtime " + 
				"            FROM " + 
				"                sys_task " + 
				"                 "+str+"" + 
				"    ) AS a " + 
				"GROUP BY maintenance_date desc limit 7";
		List<MaintenanceElevator> list  = jdbcTemplate.query(sql,new Object[] {}, new BeanPropertyRowMapper(MaintenanceElevator.class));
		return list;
	}

	
	
	@Override
	public String getmaintenanceNumber(String task_time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaultyElevator> getfaultyelevator(String city) {
	
	String str;
	if(city==null || city=="") {
		str = "";
	}else {
		str =" AND b.city="+city+" ";
	}
		
	String sql = "   SELECT " + 
			"    DATE(dday) faulty_date, " + 
			"    COUNT(*) - 1 AS faulty_count " + 
			"FROM " + 
			"    ( " + 
			"        SELECT " + 
			"            datelist AS dday " + 
			"        FROM " + 
			"            calendar " + 
			"            WHERE  DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(datelist)&&DATE(datelist)<=CURDATE() " + 
			"        UNION ALL " + 
			"            SELECT " + 
			"                a.change_time " + 
			"            FROM " + 
			"                sys_repair AS a LEFT JOIN sys_elevator AS b ON a.service_id = b.id " + 
			"                WHERE (a.traction_machine=1 OR a.room_environment=1 OR a.encoder=1 OR a.brakesclearance=1 OR a.brakespinparts=1 OR a.speedlimiter=1 OR a.operating_device=1 OR a.car_wing=1 OR a.car_door=1 OR a.show_wing=1 OR a.floor_wing=1 OR a.emergency_alarm=1 OR a.sentinel_plant=1 OR a.weigh=1 OR a.tank_guide_rail=1 OR a.button_plate=1 OR a.top_emergency_device=1 OR a.top_lubrication=1 OR a.top_vibration=1 OR a.houta_hall=1 OR a.gate_check=1 OR a.gate_operation=1 OR a.gate_interlocking=1 OR a.well_cable=1 OR a.limit_speed_switch=1 OR a.door_plank=1 OR a.light=1 OR a.sudden_stop_switch=1 OR " + 
			"a.rovolve_member=1 OR a.pond=1) "+str+"  " +  
			"    ) AS a " + 
			"GROUP BY faulty_date desc limit 7";
		
		List<FaultyElevator> list = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper(FaultyElevator.class) );
		return list;    
	}

	@Override
	public List<MaintenanceStaff> getmaintenancestaff(String city) {
		String str;
		if(city==null || city=="") {
			 str = " ";
		}else {
			 str = " where b.city="+city+"";
		}
		
		String sql = "SELECT a.user_name AS staff_name, b.address AS staff_area FROM sys_user AS a LEFT JOIN sys_elevator AS b ON a.login_name = b.user_number"+str+"";
		List<MaintenanceStaff> list = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper(MaintenanceStaff.class));
		return list;
	}

	@Override
	public List<ElevatorRate> getelevatornumber(String city) {
		//Map<String,Integer> map = new HashMap<String,Integer>();
		String str;
		if(city==null || city=="") {
			str = "";
		}else {
			str = " and city="+city+" ";
		}
		String str1;
		if(city==null || city=="") {
			str1 = "";
		}else {
			str1 = " where city="+city+" ";
		}
		//String maintenancesql = "SELECT COUNT(DISTINCT service_id) AS maintenance_count FROM sys_task WHERE DATEDIFF(NOW(),task_createtime)<=7"+str+""; 
		//String servicesql = "SELECT COUNT(*) FROM REPAIR WHERE DATEDIFF(NOW(),change_time)<=2 and service_id in (SELECT id FROM  sys_service"+str1+")";
		/*String faultysql ="SELECT COUNT(*) AS faulty_count "+
				"FROM REPAIR WHERE (traction_machine=1 OR room_environment=1 OR encoder=1 OR brakesclearance=1 "+
				"OR brakespinparts=1 OR speedlimiter=1 OR operating_device=1 OR car_wing=1 OR car_door=1 OR show_wing=1 "+
				"OR floor_wing=1 OR emergency_alarm=1 OR sentinel_plant=1 OR weigh=1 OR tank_guide_rail=1 OR button_plate=1 OR "+
				"top_emergency_device=1 OR top_lubrication=1 OR top_vibration=1 OR houta_hall=1 OR gate_check=1 OR gate_operation=1 OR "+
				"gate_interlocking=1 OR well_cable=1 OR limit_speed_switch=1 OR door_plank=1 OR light=1 OR sudden_stop_switch=1 OR "+
				"rovolve_member=1 OR pond=1) AND service_id in (SELECT id FROM sys_service"+str1+") AND DATEDIFF(NOW(),change_time)<=2";
		String normalsql = "SELECT COUNT(*) AS faulty_count "+
				"FROM REPAIR WHERE traction_machine=0 and room_environment=0 and encoder=0 and brakesclearance=0 "+
				"and brakespinparts=0 and speedlimiter=0 and operating_device=0 and car_wing=0 and car_door=0 and show_wing=0 "+
				"and floor_wing=0 and emergency_alarm=0 and sentinel_plant=0 and weigh=0 and tank_guide_rail=0 and button_plate=0 and "+
				"top_emergency_device=0 and top_lubrication=0 and top_vibration=0 and houta_hall=0 and gate_check=0 and gate_operation=0 and "+
				"gate_interlocking=0 and well_cable=0 and limit_speed_switch=0 and door_plank=0 and light=0 and sudden_stop_switch=0 and "+
				"rovolve_member=0 and pond=0 AND service_id in (SELECT id FROM  sys_service"+str1+") AND DATEDIFF(NOW(),change_time)<=2 ";*/
		List<ElevatorRate> list = new ArrayList<ElevatorRate>();
		String sql = "SELECT COUNT(DISTINCT service_id) AS y FROM sys_task WHERE DATEDIFF(NOW(),task_createtime)<=7 "+str+" UNION ALL "+
				"SELECT COUNT(*) AS y FROM sys_repair WHERE (traction_machine=1 OR room_environment=1 OR encoder=1 OR brakesclearance=1 OR brakespinparts=1 OR speedlimiter=1 OR operating_device=1 OR car_wing=1 OR car_door=1 OR show_wing=1 OR floor_wing=1 OR emergency_alarm=1 OR sentinel_plant=1 OR weigh=1 OR tank_guide_rail=1 OR button_plate=1 OR top_emergency_device=1 OR top_lubrication=1 OR top_vibration=1 OR houta_hall=1 OR gate_check=1 OR gate_operation=1 OR gate_interlocking=1 OR well_cable=1 OR limit_speed_switch=1 OR door_plank=1 OR light=1 OR sudden_stop_switch=1 OR rovolve_member=1 OR pond=1) AND service_id IN (SELECT id FROM sys_elevator "+str1+") AND DATEDIFF(NOW(),change_time)<=7 UNION ALL "+
				"SELECT COUNT(*) AS y FROM sys_repair WHERE traction_machine=0 AND room_environment=0 AND encoder=0 AND brakesclearance=0 AND brakespinparts=0 AND speedlimiter=0 AND operating_device=0 AND car_wing=0 AND car_door=0 AND show_wing=0 AND floor_wing=0 AND emergency_alarm=0 AND sentinel_plant=0 AND weigh=0 AND tank_guide_rail=0 AND button_plate=0 AND top_emergency_device=0 AND top_lubrication=0 AND top_vibration=0 AND houta_hall=0 AND gate_check=0 AND gate_operation=0 AND gate_interlocking=0 AND well_cable=0 AND limit_speed_switch=0 AND door_plank=0 AND light=0 AND sudden_stop_switch=0 AND rovolve_member=0 AND pond=0 AND service_id IN (SELECT id FROM  sys_elevator "+str1+") AND DATEDIFF(NOW(),change_time)<=7"; 
		list = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper(ElevatorRate.class));
		list.get(0).setName("维保电梯");
		list.get(1).setName("故障电梯");
		list.get(2).setName("正常工作电梯");
		return list;
		//Integer maintenance_count = jdbcTemplate.queryForObject(maintenancesql, new Object[] {}, Integer.class);
		//Integer service_count = jdbcTemplate.queryForObject(servicesql, new Object[] {}, Integer.class);
		//Integer fualty_count = jdbcTemplate.queryForObject(faultysql, new Object[] {}, Integer.class);
		//Integer normal_count = jdbcTemplate.queryForObject(normalsql, new Object[] {}, Integer.class);
		//map.put("maintenance_count", maintenance_count);
		//map.put("service_count", service_count);
		//map.put("fualty_count", fualty_count);
		//map.put("normal_count", normal_count);
		
	}
}
