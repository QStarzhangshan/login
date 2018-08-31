package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.EngineServiceDao;
import cn.zh.jdbc.domain.EngineService;
import cn.zh.jdbc.domain.Sale;
import cn.zh.jdbc.domain.Service;

@Repository
public class EngineServiceImpl implements EngineServiceDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(EngineService engineService) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into engine_room(service_id,user_number,traction_machine,room_environment,encoder"
				+ ",brakespinparts,brakesclearance,speedlimiter,operating_device) values(? , ? , ? , ? , ? , ? , ? , ? , ?)",
				engineService.getService_id(),engineService.getUser_number(),engineService.getTranction_machine(),engineService.getRoom_environment(),
				engineService.getEncoder(),engineService.getBrakespinparts(),engineService.getBrakesclearance(),engineService.getSpeedlimiter(),engineService.getOperating_device());
	}

	@Override
	public int update(EngineService engineService) {
		return jdbcTemplate.update("UPDATE engine_room SET traction_machine=? ,room_environment=? ,encoder=?,"
				+ "brakespinparts=? ,brakesclearance=?,speedlimiter=?,operating_device=? WHERE service_id=?",
				engineService.getTranction_machine(),engineService.getRoom_environment(),engineService.getEncoder(),
				engineService.getBrakespinparts(),engineService.getBrakesclearance(),engineService.getSpeedlimiter(),engineService.getOperating_device(),engineService.getService_id());
	}

	@Override
	public EngineService findByServiceId(int service_id) {
		List<EngineService> list = jdbcTemplate.query("select * from engine_room where service_id = ?", new Object[]{service_id}, new BeanPropertyRowMapper(EngineService.class));
        if(list != null && list.size() > 0){
        	System.out.println("1111111111111");
        	EngineService engineService = list.get(0);
            return engineService;
        }else{
            return null;
        }
	}

	@Override
	public List<EngineService> findAll() {
		List<EngineService> list = jdbcTemplate.query("select * from engine_room", new Object[]{}, new BeanPropertyRowMapper(EngineService.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}
	
	

}
