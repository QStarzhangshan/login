package cn.zh.jdbc.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zh.jdbc.domain.Client;
import cn.zh.jdbc.domain.Code;
import cn.zh.jdbc.domain.ContractMessage;
import cn.zh.jdbc.service.ClientService;
import cn.zh.jdbc.service.ContractMessageService;
import cn.zh.jdbc.util.ClientUtil;

@RestController
public class ContractResourceController {

		@Autowired
		ContractMessageService contractMessageService;
		
		@Autowired
		ClientService clientService;
		
		@RequestMapping(value = "/addContract",method = RequestMethod.POST)
		public List<ContractMessage> addContract(@RequestParam(value = "user_worknumber",required = false) String user_worknumber,
				@RequestParam(value = "contract_topic",required = false) String contract_topic,
				@RequestParam(value = "client_name",required = false) String client_name,
				@RequestParam(value = "amount",required = false) String amount,
				@RequestParam(value = "status",required = false) String status
	    		) throws NoSuchAlgorithmException{  
			System.out.println("-------->"+status);
			ContractMessage contractMessage = new ContractMessage();
			contractMessage.setUser_worknumber(user_worknumber);
			contractMessage.setContract_topic(contract_topic);
			contractMessage.setClient_name(client_name);
			contractMessage.setAmount(amount);
			contractMessage.setStatus(status);
			contractMessageService.add(contractMessage);
			List<ContractMessage> list = contractMessageService.findByUser(user_worknumber);
			if(list != null && list.size() >0) {
				return list;
			}
			return null;
		}
		@RequestMapping(value = "/findContract",method = RequestMethod.GET)
		public List<ContractMessage> findContract(@RequestParam(value = "user_worknumber",required = false) String user_worknumber
	    		) throws NoSuchAlgorithmException{  
			List<ContractMessage> list = contractMessageService.findByUser(user_worknumber);
			if(list != null && list.size() >0) {
				return list;
			}
			return null;
		}
		//有疑问
		@RequestMapping(value = "/findAllClient",method = RequestMethod.GET)
		public List<ClientUtil> findAllClient(@RequestParam(value = "user_worknumber",required = false) String user_worknumber
	    		) throws NoSuchAlgorithmException{  
			List<Client> list = clientService.findAllCount(user_worknumber);
			System.out.println("1"+1);
			if(list != null && list.size() >0) {
				List<ClientUtil> listU = new ArrayList<>(); 
				System.out.println("1"+1);
				for (int i = 0; i < list.size(); i++) {
					ClientUtil client = new ClientUtil();
					client.setClient_name(list.get(i).getClient_name());
					System.out.println("2"+client.getClient_name());
					listU.add(client);
				}
				return listU;
			}
			return null;
		}
		
		@RequestMapping(value = "/updateContract",method = RequestMethod.POST)
		public Code update(@RequestParam(value = "id",required = false) int id
	    		) {  
			ContractMessage contractMessage = new ContractMessage();
			contractMessage.setId(id);
			contractMessageService.update(contractMessage);
			Code code = new Code();
			code.setCode(1);
			return code;
			
		}
	
}
