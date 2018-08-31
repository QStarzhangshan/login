package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.EngineService;

public interface EngineServiceDao {
	
	int add(EngineService engineService);
	
	int update(EngineService engineService);
	
	List<EngineService> findAll();
	
	EngineService findByServiceId(int service_id);

}
