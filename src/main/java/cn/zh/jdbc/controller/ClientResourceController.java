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

import cn.zh.jdbc.domain.Client;
import cn.zh.jdbc.domain.Code;
import cn.zh.jdbc.domain.Sign;
import cn.zh.jdbc.service.ClientService;
import cn.zh.jdbc.service.SignService;

@RestController
public class ClientResourceController {

	@Autowired
	ClientService clientService;
	
	@Autowired
	SignService signService;
	
	@RequestMapping(value = "/addClient",method = RequestMethod.POST)
	@ResponseBody
    public Code client(HttpServletRequest request,@RequestParam(value = "user_worknumber",required = false) String user_worknumber,
    		@RequestParam(value = "client_name",required = false) String client_name,
    		@RequestParam(value = "client_industry",required = false) String client_industry,
    		@RequestParam(value = "client_phone",required = false) String client_phone,
    		@RequestParam(value = "client_create_time",required = false) String client_create_time
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+user_worknumber);
		System.out.println("------>"+client_name);
		Client client = new Client();
		client.setClient_owner_worknumber(user_worknumber);
		client.setClient_name(client_name);
		client.setClient_create_time(client_create_time);
		client.setClient_industry(client_industry);
		client.setClient_phone(client_phone);
		clientService.add(client);
		Code code = new Code();
		code.setCode(Integer.parseInt(user_worknumber));
		return code;
    }  
	
	@RequestMapping(value = "/getClient",method = RequestMethod.POST)
	@ResponseBody
    public List<Client> getsale(HttpServletRequest request,@RequestParam(value = "client_owner_worknumber",required = false) String client_owner_worknumber){  
		List<Client> list = clientService.findByClientOwnerNumber(client_owner_worknumber);
		return list;
		
    }
	
	@RequestMapping(value = "/getClientId",method = RequestMethod.POST)
	@ResponseBody
    public Client getsaleId(HttpServletRequest request,@RequestParam(value = "client_id",required = false) String client_id){  
		Client client = clientService.findByClientId(client_id);
		if(client != null) {
			return client;
		}
		return null;
    }  
	
	@RequestMapping(value = "/updateClientInfo",method = RequestMethod.POST)
	@ResponseBody
    public Client updateSaleId(HttpServletRequest request,
    		@RequestParam(value = "client_id",required = false) int client_id,
    		@RequestParam(value = "client_phone",required = false) String client_phone,
    		@RequestParam(value = "client_industry",required = false) String client_industry,
    		@RequestParam(value = "client_update_time",required = false) String client_update_time){  
		Client client = new Client();
		client.setClient_id(client_id);
		client.setClient_phone(client_phone);
		client.setClient_industry(client_industry);
		client.setClient_update_time(client_update_time);
		clientService.update(client);
		return client;
    }  
	
	

}
