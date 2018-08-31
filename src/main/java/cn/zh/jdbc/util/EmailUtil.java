package cn.zh.jdbc.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class EmailUtil {

	@Autowired
    private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
    private String Sender; //读取配置文件中的参数
	
	public void sendHtmlMail(String email) {
        MimeMessage message = null;
        try {
        	System.out.println(email);
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo(Sender);
            helper.setSubject("标题：找回密码");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>找回密码</h1>")
                    .append("<p style='color:#F00'><a>localhost:8080/resetPass</a></p>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        mailSender.send(message);
    }
}
