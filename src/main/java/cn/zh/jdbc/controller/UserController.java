package cn.zh.jdbc.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.zh.jdbc.domain.User;
import cn.zh.jdbc.identifyCode.Captcha;
import cn.zh.jdbc.identifyCode.GifCaptcha;
import cn.zh.jdbc.service.UserService;
import cn.zh.jdbc.util.BASE64Util;
import cn.zh.jdbc.util.Md5Util;

@Controller
@RequestMapping("/*")
public class UserController {

    @Autowired
    UserService userService;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数

    HttpSession session;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public  List<User> getUsers(){
       return userService.findUserList();
    }
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
    
    
//    @RequestMapping("/")  
//    public String login(){  
//        return "login";  
//    } 
    /**
	 * 登录操作
	 **/
	@RequestMapping(value = "/submitlogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitlogin(HttpServletRequest request, String user_work_number, String basepassword,
			String verification, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("工号：" + user_work_number + "----" + "base64加密密码：" + basepassword + "----" + "验证码：" + verification);
		String password = null;
		// 转化成小写字母
		verification = verification.toLowerCase();// toLowerCase()// 方法用于将大写字符转换为小写。
		String v = (String) session.getAttribute("_code");// 表示得到 域中的对象// 返回的是OBJ类型
		// 读取一次后把验证码清空，这样每次登录都必须获取验证码
		session.removeAttribute("_come");
		System.out.println("用户输入验证码:" + verification + "--------" + "动态生成的验证码：" + v);
		if (user_work_number.equals("") || user_work_number == "") {
			map.put("result", "1");
		} else if (basepassword.equals("") || basepassword == "") {
			map.put("result", "2");
		} else if (verification.equals("") || verification == "") {
			map.put("result", "3");
		} else if (!verification.equals(v)) {
			map.put("result", "5");
			return map;
		} else {
			System.out.println("使用base64解密后密码：" + BASE64Util.decode(basepassword));
			String passwordjie = BASE64Util.decode(basepassword);
			try {
				System.out.println("md5加密以后的结果:" + Md5Util.md5(passwordjie));
				password = Md5Util.md5(passwordjie);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("md5加密异常：");
				e.printStackTrace();
			}
			int h = userService.findByUser(user_work_number, password);
			User user = userService.findByUserWorkNumber(user_work_number);
			if (h == 1) {
				map.put("result", "0");
			} else {
				map.put("result", "4");
			}
		}
		return map;
	}
    
	    // 登录
		@RequestMapping(value = "/")
		public String login(HttpServletRequest request, Model model) {
			session = request.getSession();
			// 当前设置session 存验证码 注意：我们要在服务器数据发送到客户端之前设置session 否则会报错
			return "login";
		}
//	@RequestMapping("/toRegist")
//    public String register(){
//        return "register";
//    }
	@RequestMapping("/toRegist")
    public String register1(HttpServletRequest request, Model model){
		session = request.getSession();
        return "register1";
    }
	/**
	 * 注册
	 **/
	@RequestMapping(value = "/register1", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request, String user_name ,String user_work_number, String user_password,
			String password,String verification, String user_email,Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String userpassword = null;
		// 转化成小写字母
		verification = verification.toLowerCase();// toLowerCase()// 方法用于将大写字符转换为小写。
		String v = (String) session.getAttribute("_code");// 表示得到 域中的对象// 返回的是OBJ类型
		// 读取一次后把验证码清空，这样每次登录都必须获取验证码
		session.removeAttribute("_come");
		System.out.println("用户输入验证码:" + verification + "--------" + "动态生成的验证码：" + v);
		boolean h = userService.findWorkNumber(user_work_number);
		if (!h) {
			map.put("result", "0");
			try {
				userpassword = Md5Util.md5(user_password);
				User user = new User();
				user.setUser_name(user_name);
				user.setUser_work_number(user_work_number);
				user.setUser_password(userpassword);
				user.setUser_email(user_email);
				userService.add(user);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("md5加密异常：");
				e.printStackTrace();
			}
		}else if(user_name.equals("") || user_name == "") {
			map.put("result", "1");
		}else if (user_work_number.equals("") || user_work_number == "") {
			map.put("result", "4");
		} else if (user_password.equals("") || user_password == "") {
			map.put("result", "2");
		} else if (password.equals("") || password == "") {
			map.put("result", "3");
		} else if (verification.equals("") || verification == "") {
			map.put("result", "5");
		} else if (!user_password.equals(password)) {
			map.put("result", "7");
		}else if (!verification.equals(v)) {
			map.put("result", "6");
			return map;
		} else {
			if(h) {
				map.put("result", "8");
			}
		}
		return map;
	}
	
    @RequestMapping("/register")
    public String register(HttpServletRequest request) throws NoSuchAlgorithmException{
        String username = request.getParameter("username");
        String work_number = request.getParameter("work_number");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String user_email = request.getParameter("user_email");
        if(password == null || password2 == null) {
            return "register";
        }
        if (password.equals(password2) & password != null & password2 != null){
            User user = new User();
            user.setUser_name(username);
            user.setUser_work_number(work_number);
            user.setUser_password(Md5Util.md5(password));
            user.setUser_email(user_email);
            userService.add(user);
            return "login";
        }else {
        	return "register";
        }
    }
    
    @RequestMapping("/reset")
    public String reset(){
        return "reset";
    }
    
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)  
    public String loginByGet(@RequestParam(value = "user_work_number", required = true) String user_work_number,  
            @RequestParam(value = "user_email", required = true) String user_email) {
    	boolean bl = userService.findByNumberAndEmail(user_work_number, user_email);
    	if(bl) {
    		new Thread(new Runnable() {
				
				@Override
				public void run() {
					MimeMessage message = null;
			        try {
			            message = mailSender.createMimeMessage();
			            MimeMessageHelper helper = new MimeMessageHelper(message, true);
			            helper.setFrom(Sender);
			            helper.setTo(user_email);
			            helper.setSubject("标题：找回密码");
			            StringBuffer sb = new StringBuffer();
			            sb.append("<h1>找回密码</h1>")
			                    .append("<p style='color:#F00'><a href='http://localhost:8080/resetPass'>http://localhost:8080/resetPass</a></p>");
			            helper.setText(sb.toString(), true);
			        } catch (Exception e) {
			            e.printStackTrace(); 
			        }
			        mailSender.send(message);
				}
			}).start();
    		return "redirect:/";
    	}else {
    		return "/reset";
    	}
      
    }
    
    @RequestMapping("/resetPass")
    public String resetPass(){
        return "resetPass";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  User getAccountById(@PathVariable("username") String username,@PathVariable("password") String password){
        return userService.findByUserAndPassword(username, password);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateUser(@PathVariable("id")int id , @RequestParam(value = "username",required = true)String username,
    @RequestParam(value = "password" ,required = true)String password){
        User user=new User();
        user.setUser_id(id);
        user.setUser_name(username);
        user.setUser_password(password);
        int t=userService.update(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "username")String username,
                                 @RequestParam(value = "password" )String password){
        User user=new User();
        user.setUser_name(username);
        user.setUser_password(password);
        int t= userService.add(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }

    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete( @RequestParam("id")int id ){
        int t= userService.delete(id);
        System.out.println(t);
        if(t==1){
            return "true";
        }else {
            return "fail";
        }

    }
    /**
	 * 获取验证码（Gif版本）
	 *
	 * @param response
	 */
	@RequestMapping(value = "getGifCode", method = RequestMethod.GET)
	public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/gif");
			/**
			 * gif格式动画验证码 宽，高，位数。
			 */
			Captcha captcha = new GifCaptcha(146, 33, 4);
			// 输出
			captcha.out(response.getOutputStream());
			// 存入Session
			session.setAttribute("_code", captcha.text().toLowerCase());
		} catch (Exception e) {
			System.err.println("获取验证码异常：" + e.getMessage());
		}
	}
}
