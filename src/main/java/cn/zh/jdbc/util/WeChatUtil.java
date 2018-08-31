package cn.zh.jdbc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSONObject;

public class WeChatUtil {

	public JSONObject weChatlogin(String code){ 
		System.out.println("----->"+code);
		 URL url;
		 JSONObject json = null;
		try {
			url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=wx5cc02328a0c2cef3&secret=0684f998f96cd808ec9c1421d2af3d3d&js_code="+code+"&grant_type=authorization_code");
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
