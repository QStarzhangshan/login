package cn.zh.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zh.jdbc.domain.Message;
import cn.zh.jdbc.service.MessageService;

@RestController
public class MessageResourceController {

	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "/getMessage",method = RequestMethod.GET)
	@ResponseBody
	public List<Message> getMessage(@RequestParam(value = "send_user",required = false) String send_user) {
		List<Message> list = messageService.findMessage(send_user);
		if(list != null & list.size() > 0) {
			return list;
		}
		return null;
		
	}
	
	@RequestMapping(value = "/searchMessage",method = RequestMethod.GET)
	@ResponseBody
	public Message searchMessage(@RequestParam(value = "id",required = false) int id
			) {
		Message message = messageService.findBySendToUser(id);
		System.out.println(message.getSend_user());
		if(message != null ) {
			Message message1 = new Message();
			message1.setId(id);
			message1.setIsRead("1");
			messageService.update(message1);
			return message;
		}
		return null;
	}
	@RequestMapping(value = "/updateMessage",method = RequestMethod.POST)
	@ResponseBody
	public Message updateMessage(@RequestParam(value = "id",required = false) int id) {
		Message message = messageService.findBySendToUser(id);
		if(message != null ) {
			return message;
		}
		return null;
	}
}
