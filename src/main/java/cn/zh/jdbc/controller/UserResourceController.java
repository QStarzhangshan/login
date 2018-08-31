package cn.zh.jdbc.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.zh.jdbc.domain.User;
import cn.zh.jdbc.domain.WeChatUser;
import cn.zh.jdbc.domain.WeUser;
import cn.zh.jdbc.service.UserService;
import cn.zh.jdbc.util.Md5Util;
import cn.zh.jdbc.util.WeChatUtil;

@RestController
public class UserResourceController {

	@Autowired
    UserService userService;
	
	@RequestMapping(value = "/weChatLogin",method = RequestMethod.POST)
	@ResponseBody
    public WeUser login(HttpServletRequest request,@RequestParam(value = "user_work_number",required = false) String user_work_number,
    		 @RequestParam(value = "user_name" ,required = false) String user_name,
    		 @RequestParam(value = "code" ,required = false) String weCode
    		) throws NoSuchAlgorithmException {  
		System.out.println("----->"+user_work_number);
		System.out.println("--------->"+user_name);
		System.out.println("------------>"+weCode);
		WeChatUtil weChat = new WeChatUtil();
		String openid = (String) weChat.weChatlogin(weCode).get("openid");
		System.out.println("------------------>"+openid);
		User user = new User();
		user.setUser_work_number(user_work_number);
		user.setUser_name(user_name);
		user.setUser_password(Md5Util.md5("123456"));
		user.setOpenid(openid);
		userService.save(user);
		
		WeUser user1 = new WeUser();
		user1.setUser_work_number(user_work_number);
		user1.setUser_name(user_name);
		user1.setOpenid(openid);
        return user1;
    } 
	
	@RequestMapping(value = "/weChat",method = RequestMethod.POST)
	@ResponseBody
    public WeChatUser wechat(HttpServletRequest request,
    		 @RequestParam(value = "code" ,required = false) String weCode
    		){  
		System.out.println("------------>"+weCode);
		WeChatUtil weChat = new WeChatUtil();
		String openid = (String) weChat.weChatlogin(weCode).get("openid");
		WeChatUser user = new WeChatUser();
		List<User> list = userService.findByCode(openid);
		if(list != null && list.size() > 0) {
			user.setCode(1);;
			user.setUser_work_number(list.get(0).getUser_work_number());
			user.setUser_name(list.get(0).getUser_name());
			return user;
		}
        return null;
    }
	
	@RequestMapping(value = "/weChatInfo",method = RequestMethod.POST)
	@ResponseBody
    public User wechatInfo(HttpServletRequest request,
    		 @RequestParam(value = "user_work_number" ,required = false) String user_work_number
    		) {  
		System.out.println("------------>"+user_work_number);
		User user = userService.findByUserWorkNumber(user_work_number);
		if(user != null) {
			return user;
		}
        return null;
    }
	
	
	@RequestMapping(value = "/weChatUpDateInfo",method = RequestMethod.POST)
	@ResponseBody
    public User wechatUpInfo(HttpServletRequest request,
    		 @RequestParam(value = "user_work_number" ,required = false) String user_work_number,
    		 @RequestParam(value = "user_cellphone" ,required = false) String user_cellphone,
    		 @RequestParam(value = "user_email" ,required = false) String user_email,
    		 @RequestParam(value = "user_company" ,required = false) String user_company,
    		 @RequestParam(value = "user_department" ,required = false) String user_department,
    		 @RequestParam(value = "user_position" ,required = false) String user_position
    		) {  
		System.out.println("------update------>"+user_work_number);
		User user = new User();
		user.setUser_cellphone(user_cellphone);
		user.setUser_email(user_email);
		user.setUser_company(user_company);
		user.setUser_department(user_department);
		user.setUser_position(user_position);
		user.setUser_work_number(user_work_number);
		userService.updateInfo(user);
		if(true) {
			User user1 = new User();
			user1.setUser_cellphone(user_cellphone);
			user1.setUser_email(user_email);
			user1.setUser_company(user_company);
			user1.setUser_department(user_department);
			user1.setUser_position(user_position);
			user1.setUser_work_number(user_work_number);
			return user1;
		}
		return null;
    }
	
	@RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUser(){
		List<User> list = userService.findUserList();
		if(list != null & list.size() > 0) {
			return list;
		}
		return null;
	}
	
}
