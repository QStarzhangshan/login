package cn.zh.jdbc.service;

import java.util.List;

import cn.zh.jdbc.domain.ContractMessage;

public interface ContractMessageService {

	int add(ContractMessage contractMessage);

    List<ContractMessage> findByUser(String user_worknumber);
    
    ContractMessage findByContractId(String contract_id);
    
    int update(ContractMessage contractMessage);
	
}
