package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.ContractMessageDao;
import cn.zh.jdbc.domain.ContractMessage;
import cn.zh.jdbc.service.ContractMessageService;

@Service
public class ContractMessageServiceImpl implements ContractMessageService{

	@Autowired
	ContractMessageDao contractMessageDao;
	
	@Override
	public int add(ContractMessage contractMessage) {
		// TODO Auto-generated method stub
		return contractMessageDao.add(contractMessage);
	}

	@Override
	public List<ContractMessage> findByUser(String user_worknumber) {
		// TODO Auto-generated method stub
		return contractMessageDao.findByUser(user_worknumber);
	}

	@Override
	public ContractMessage findByContractId(String contract_id) {
		// TODO Auto-generated method stub
		return contractMessageDao.findByContractId(contract_id);
	}

	@Override
	public int update(ContractMessage contractMessage) {
		// TODO Auto-generated method stub
		return contractMessageDao.update(contractMessage);
	}

}
