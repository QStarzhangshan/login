package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.Message;

public interface MessageDao {

	int add(Message message);
	
	int update(Message message);
	
	List<Message> findMessage(String send_user);
	
	Message findBySendToUser(int id);
	
}
