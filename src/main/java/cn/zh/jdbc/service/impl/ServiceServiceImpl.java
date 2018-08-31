package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zh.jdbc.dao.ServiceDao;
import cn.zh.jdbc.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{
	
	@Autowired
	private ServiceDao serviceDao;

	@Override
	public int add(cn.zh.jdbc.domain.Service service) {
		// TODO Auto-generated method stub
		return serviceDao.add(service);
	}

	@Override
	public int update(cn.zh.jdbc.domain.Service service) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<cn.zh.jdbc.domain.Service> findServiceList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<cn.zh.jdbc.domain.Service> findByServiceNumber(String user_number) {
		// TODO Auto-generated method stub
		return serviceDao.findByServiceNumber(user_number);
	}

	@Override
	public cn.zh.jdbc.domain.Service findByServiceId(int id) {
		// TODO Auto-generated method stub
		return serviceDao.findByServiceId(id);
	}

	@Override
	public List<cn.zh.jdbc.domain.Service> likeSearch(String usernumber, String elevator_number) {
		// TODO Auto-generated method stub
		return serviceDao.likeSearch(usernumber, elevator_number);
	}

	@Override
	public int getCount(String user_number) {
		// TODO Auto-generated method stub
		return serviceDao.getCount(user_number);
	}
	
	
	

}
