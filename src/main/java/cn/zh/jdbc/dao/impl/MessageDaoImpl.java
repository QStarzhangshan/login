package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.MessageDao;
import cn.zh.jdbc.domain.Client;
import cn.zh.jdbc.domain.Message;

@Repository
public class MessageDaoImpl implements MessageDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Message message) {
		return jdbcTemplate.update("insert into message(send_user,send_username,send_topic,sendto_user) values(?,?,?,?)", 
				message.getSend_user(),message.getSend_username(),message.getSend_topic(),message.getSendto_user());
	}
	
	@Override
	public int update(Message message) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE message SET isRead=? WHERE id=?",
				message.getIsRead(),message.getId());
	}
	@Override
	public Message findBySendToUser(int id) {
		List<Message> list =  jdbcTemplate.query("select * from message where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Message.class));
		if(list != null & list.size() > 0) {
			Message message = list.get(0);
			return message;
		}
		return null;
	}

	@Override
	public List<Message> findMessage(String send_user) {
		List<Message> list =  jdbcTemplate.query("select * from message where send_user = ?", new Object[]{send_user}, new BeanPropertyRowMapper(Message.class));
		if(list != null & list.size() > 0) {
			return list;
		}
		return null;
	}

	

}
