package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.LocationDao;
import cn.zh.jdbc.domain.EngineService;
import cn.zh.jdbc.domain.ClientByMap;
import cn.zh.jdbc.domain.Location;
import cn.zh.jdbc.domain.MaintenanceByMap;

@Repository
public class LocationDaoImpl implements LocationDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Location> getLocation() {
		List<Location> list = jdbcTemplate.query("select latitude,longitude from sys_location", new Object[]{}, new BeanPropertyRowMapper(Location.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

	@Override
	public List<ClientByMap> getinfoByMap() {
		 
		String sql = "select a.latitude,a.longitude,b.city,b.status,b.area,b.building,b.run_time from "+
				"sys_location as a,sys_service as b where a.id=b.lid";
		List<ClientByMap> list = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper(ClientByMap.class));
		
		if(list !=null && list.size()>0) {
			return list;
			
		}else{
			return null;
		}
	}

	@Override
	public List<ClientByMap> getclientbymap() {
		String sql = "SELECT t.maintenance_company,t.task_createtime,u.user_name,u.phonenumber,e.client_name,e.address,e.registration_code,e.contact_name,e.contact_phone,r.status,e.latitude,e.longitude FROM sys_task AS t,sys_elevator AS e,sys_repair AS r,sys_user AS u WHERE t.service_id=e.id AND t.user_number=u.login_name AND r.service_id=e.id" +  
				"" ;
		List<ClientByMap> list = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper(ClientByMap.class));
		return list;
	}

	@Override
	public List<MaintenanceByMap> getmaintenancebymap() {
		String sql = "SELECT sys_user.user_name,sys_user.phonenumber,repair.status,sys_location.latitude,sys_location.longitude FROM sys_user,sys_task,sys_location, REPAIR WHERE sys_user.login_name=sys_task.user_number AND sys_task.service_id=sys_location.service_id AND sys_location.service_id=repair.service_id";
		List<MaintenanceByMap> list = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper(MaintenanceByMap.class));
		return list;
	}
}
