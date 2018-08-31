package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cn.zh.jdbc.dao.ClientDao;
import cn.zh.jdbc.domain.Client;


@Repository
public class ClientDaoImpl implements ClientDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Client client) {
		return jdbcTemplate.update("insert into user_client(sale_id,client_name,client_owner_worknumber,client_level,client_number,"
				+ "client_phone,client_location,client_location_detail,client_note,client_company_area,client_department,client_position,client_industry,client_create_time,client_update_time) values(? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?, ?)",
				client.getSale_id(),client.getClient_name(),client.getClient_owner_worknumber(),client.getClient_level(),client.getClient_number(),
				client.getClient_phone(),client.getClient_location(),client.getClient_location_detail(),client.getClient_note(),client.getClient_company_area(),client.getClient_department(),client.getClient_position(),client.getClient_industry(),client.getClient_create_time(),client.getClient_update_time());
	}

	@Override
	public int update(Client client) {
		return jdbcTemplate.update("UPDATE user_client SET client_phone=?,client_industry=?,client_update_time=?WHERE client_id=?",
        		client.getClient_phone(),client.getClient_industry(),client.getClient_update_time(),client.getClient_id());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE from user_client where sale_id =?",id);
	}

	@Override
	public List<Client> findClientList() {
		List<Client> list = jdbcTemplate.query("select * from user_client", new Object[]{}, new BeanPropertyRowMapper(Client.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}

	@Override
	public List<Client> findByClientOwnerNumber(String client_owner_worknumber) {
		 List<Client> list = jdbcTemplate.query("select * from user_client where client_owner_worknumber = ? order by client_id desc", new Object[]{client_owner_worknumber}, new BeanPropertyRowMapper(Client.class));
	        if(list != null && list.size() > 0){
	            return list;
	        }else{
	            return null;
	        }
	}

	@Override
	public Client findByClientId(String client_id) {
		List<Client> list = jdbcTemplate.query("select * from user_client where client_id = ?", new Object[]{client_id}, new BeanPropertyRowMapper(Client.class));
        if(list != null && list.size() > 0){
        	Client client = list.get(0);
            return client;
        }else{
            return null;
        }
	}

	@Override
	public List<Client> findAllCount(String user_worknumber) {
		List<Client> list = jdbcTemplate.query("select client_name from user_client where client_owner_worknumber = ?", new Object[]{user_worknumber}, new BeanPropertyRowMapper(Client.class));
        if(list != null && list.size() > 0){
            return list;
        }else{
            return null;
        }
	}
	

}
