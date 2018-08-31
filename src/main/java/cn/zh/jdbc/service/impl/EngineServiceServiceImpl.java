package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.EngineServiceDao;
import cn.zh.jdbc.domain.EngineService;
import cn.zh.jdbc.service.EngineServiceService;

@Service
public class EngineServiceServiceImpl implements EngineServiceService{
	
	
	@Autowired
	private EngineServiceDao engineServiceDao;

	@Override
	public int add(EngineService engineService) {
		// TODO Auto-generated method stub
		return engineServiceDao.add(engineService);
	}

	@Override
	public int update(EngineService engineService) {
		// TODO Auto-generated method stub
		return engineServiceDao.update(engineService);
	}

	@Override
	public EngineService findByServiceId(int service_id) {
		// TODO Auto-generated method stub
		return engineServiceDao.findByServiceId(service_id);
	}

	@Override
	public List<EngineService> findAll() {
		// TODO Auto-generated method stub
		return engineServiceDao.findAll();
	}

}
