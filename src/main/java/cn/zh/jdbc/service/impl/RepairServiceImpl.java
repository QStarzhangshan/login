package cn.zh.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.RepairDao;
import cn.zh.jdbc.domain.Repair;
import cn.zh.jdbc.service.RepairService;

@Service
public class RepairServiceImpl implements RepairService{
	
	@Autowired
	private RepairDao repairDao;

	@Override
	public int update(Repair repair) {
		// TODO Auto-generated method stub
		return repairDao.update(repair);
	}
}
