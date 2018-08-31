package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.domain.User;
import cn.service.UserService;

public class TestApp {
	@Test
	public void demo1() {
		User user = new User();
		user.setUsername("ok");
		user.setPassword("123456");
		String pathxml = "applicationContext.xml";
		ApplicationContext applicationcontext = new ClassPathXmlApplicationContext(pathxml);
		UserService userService = applicationcontext.getBean("userService", UserService.class);
		userService.saveUser(user);
	}
}
