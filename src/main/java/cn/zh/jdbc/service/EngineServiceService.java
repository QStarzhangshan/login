package cn.zh.jdbc.service;

import java.util.List;

import cn.zh.jdbc.domain.EngineService;

public interface EngineServiceService {

	int add(EngineService engineService);
	
	int update(EngineService engineService);
	
	EngineService findByServiceId(int service_id);
	
	List<EngineService> findAll();
}
