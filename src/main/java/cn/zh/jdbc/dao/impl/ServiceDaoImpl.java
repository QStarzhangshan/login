package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.ServiceDao;
import cn.zh.jdbc.domain.Sale;
import cn.zh.jdbc.domain.Service;

@Repository
public class ServiceDaoImpl implements ServiceDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Service service) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into sys_service(user_number,province,city,area,building,elevator_number,service_type,run_time) values(? , ? , ? , ? , ? , ? , ?,?)",
        		service.getUser_number(),service.getProvince(),service.getCity(),service.getArea(),service.getBuilding(),service.getElevator_number(),service.getService_type(),service.getRun_time());
	}

	@Override
	public int update(Service service) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Service> findServiceList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Service> findByServiceNumber(String user_number) {
		List<Service> list = jdbcTemplate.query("select * from sys_service where user_number = ? order by id desc", new Object[]{user_number}, new BeanPropertyRowMapper(Service.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

	@Override
	public Service findByServiceId(int id) {
		List<Service> list = jdbcTemplate.query("select * from sys_service where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Service.class));
        if(list != null && list.size() > 0){
        	Service service = list.get(0);
            return service;
        }else{
            return null;
        }
	}

	@Override
	public List<Service> likeSearch(String usernumber, String elevator_number) {
		List<Service> list = jdbcTemplate.query("select * from sys_service where user_number = '"+usernumber+"' and elevator_number LIKE '%"+elevator_number+"%' order by id desc", new BeanPropertyRowMapper(Service.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

	@Override
	public int getCount(String user_number) {
		List<Service> list = jdbcTemplate.query("SELECT * FROM sys_service WHERE user_number=?",new Object[]{user_number}, new BeanPropertyRowMapper(Service.class));
        if(list != null && list.size() > 0){
        	System.out.println(list.size());
            return list.size();
        }else{
            return 0;
        }
	}
	
	

}
