package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.ContractMessageDao;
import cn.zh.jdbc.domain.ContractMessage;

@Repository
public class ContractMessageDaoImpl implements ContractMessageDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int add(ContractMessage contractMessage) {
		return jdbcTemplate.update("insert into contract_message(user_worknumber,contract_topic,client_name,"
				+ "amount,status) values(? , ? , ? , ? , ?)",
				contractMessage.getUser_worknumber(),contractMessage.getContract_topic(),contractMessage.getClient_name(),
				contractMessage.getAmount(),contractMessage.getStatus()
				);
	}

	@Override
	public List<ContractMessage> findByUser(String user_worknumber) {
		List<ContractMessage> list = jdbcTemplate.query("select * from contract_message where user_worknumber = ? order by id desc", new Object[]{user_worknumber}, new BeanPropertyRowMapper(ContractMessage.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

	@Override
	public ContractMessage findByContractId(String contract_id) {
		List<ContractMessage> list = jdbcTemplate.query("select * from user_client where id = ?", new Object[]{contract_id}, new BeanPropertyRowMapper(ContractMessage.class));
        if(list != null && list.size() > 0){
        	ContractMessage contractMessage = list.get(0);
            return contractMessage;
        }else{
            return null;
        }
	}

	@Override
	public int update(ContractMessage contractMessage) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE contract_message SET status=1 WHERE id=?",contractMessage.getId());
	}

	
    
}
