package cn.zh.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.PitDao;
import cn.zh.jdbc.domain.Pit;
import cn.zh.jdbc.service.PitService;

@Service
public class PitServiceImpl implements PitService{

	@Autowired
	private PitDao pitDao;

	@Override
	public int update(Pit pit) {
		// TODO Auto-generated method stub
		return pitDao.update(pit);
	}
	
	
	
	
	
}
