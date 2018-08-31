package cn.zh.jdbc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class WeChatController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
    public static final String WX_APPID = "wxa194240f3a08b139";
    public static final String WX_APPSECRET = "741ff6935cbc825cd83ddcc55dbfdce3";
	
	@RequestMapping(value = "/sendCode",method = RequestMethod.POST)
	@ResponseBody
    public JSONObject weChatlogin(@RequestParam(value = "code",required = false) String code
    		){ 
		System.out.println("----->"+code);
		 URL url;
		 JSONObject json = null;
		try {
			url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=wxa194240f3a08b139&secret=741ff6935cbc825cd83ddcc55dbfdce3&js_code="+code+"&grant_type=authorization_code");
			URLConnection urlcon = url.openConnection();
			urlcon.connect();
			InputStream is = urlcon.getInputStream();  
		       BufferedReader buffer = new BufferedReader(new InputStreamReader(is));  
		       StringBuffer bs = new StringBuffer(); 
		       System.out.println(bs);
		       String l = null;  
		       while((l=buffer.readLine())!=null){  
		           bs.append(l);  
		       }  
		       System.out.println(bs.toString());
		       json = JSONObject.parseObject(bs.toString());
		       System.out.println("--->"+json.get("openid"));
		       return json;
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return json;
    }
}
