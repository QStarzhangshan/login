package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.MessageDao;
import cn.zh.jdbc.domain.Message;
import cn.zh.jdbc.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;
	
	@Override
	public int add(Message message) {
		// TODO Auto-generated method stub
		return messageDao.add(message);
	}

	@Override
	public int update(Message message) {
		// TODO Auto-generated method stub
		return messageDao.update(message);
	}

	@Override
	public Message findBySendToUser(int id) {
		// TODO Auto-generated method stub
		return messageDao.findBySendToUser(id);
	}

	@Override
	public List<Message> findMessage(String send_user) {
		// TODO Auto-generated method stub
		return messageDao.findMessage(send_user);
	}

}
