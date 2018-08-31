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
import cn.zh.jdbc.domain.Sale;
import cn.zh.jdbc.domain.Sign;
import cn.zh.jdbc.service.ClientService;
import cn.zh.jdbc.service.SaleService;
import cn.zh.jdbc.service.SignService;

@RestController
public class SaleResourceController {
	@Autowired
    SaleService saleService;
	@Autowired
	ClientService clientService;
	@Autowired
	SignService signService;
	
	@RequestMapping(value = "/addSale",method = RequestMethod.POST)
	@ResponseBody
    public Code sale(HttpServletRequest request,@RequestParam(value = "user_worknumber",required = false) String user_worknumber,
    		@RequestParam(value = "client_name",required = false) String client_name,
    		@RequestParam(value = "sale_name",required = false) String sale_name,
    		 @RequestParam(value = "sale_create_time" ,required = false) String sale_create_time
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+user_worknumber);
		System.out.println("------>"+client_name);
		System.out.println("------->"+sale_name);
		System.out.println("--------->"+sale_create_time);
		Sale sale = new Sale();
		sale.setUser_worknumber(user_worknumber);
		sale.setClient_name(client_name);
		sale.setSale_name(sale_name);
		sale.setSale_create_time(sale_create_time);
        saleService.add(sale);
        Client client = new Client();
        Code code = new Code();
        List<Sale> list = saleService.findBySaleNumber(user_worknumber); 
        if(list.size() > 0 ) {
        	Sale sale_id = saleService.findByUserWorkNumber(user_worknumber);
        	code.setCode(Integer.parseInt(user_worknumber));
        	client.setClient_name(client_name);
        	client.setSale_id(sale_id.getSale_id());
        	client.setClient_owner_worknumber(user_worknumber);
        	client.setClient_create_time(sale_create_time);
        	clientService.add(client);
        	return code;
        }
        return null;
        
    }  
	
	
	@RequestMapping(value = "/getSale",method = RequestMethod.POST)
	@ResponseBody
    public List<Sale> getsale(HttpServletRequest request,@RequestParam(value = "user_worknumber",required = false) String user_worknumber){  
		List<Sale> list = saleService.findBySaleNumber(user_worknumber);
		return list;
		
    }  
	
	@RequestMapping(value = "/getSaleId",method = RequestMethod.POST)
	@ResponseBody
    public Sale getsaleId(HttpServletRequest request,@RequestParam(value = "sale_id",required = false) int sale_id){  
		Sale sale = saleService.findBySaleId(sale_id);
		if(sale != null) {
			return sale;
		}
		return null;
    } 
	
	@RequestMapping(value = "/updateSaleId",method = RequestMethod.POST)
	@ResponseBody
    public Sale upateSaleId(HttpServletRequest request,
    		@RequestParam(value = "sale_id",required = false) int sale_id,
    		@RequestParam(value = "sale_name",required = false) String sale_name,
    		@RequestParam(value = "sale_level",required = false) String sale_level,
    		@RequestParam(value = "client_name",required = false) String client_name,
    		@RequestParam(value = "sale_update_time",required = false) String sale_update_time){  
		Sale sale = new Sale();
		sale.setClient_name(client_name);
		sale.setSale_level(sale_level);
		sale.setSale_name(sale_name);
		sale.setSale_update_time(sale_update_time);
		sale.setSale_id(sale_id);
		saleService.update(sale);
		Client client = new Client();
		client.setClient_name(client_name);
		client.setSale_id(sale_id);
		client.setClient_update_time(sale_update_time);
		clientService.update(client);
		return sale;
    }
	@RequestMapping(value = "/deleteSaleId",method = RequestMethod.POST)
	@ResponseBody
    public Code deleSaleId(HttpServletRequest request,@RequestParam(value = "sale_id",required = false) int sale_id){
		saleService.delete(sale_id);
		clientService.delete(sale_id);
		Sale sale = saleService.findBySaleId(sale_id);
		Code code = new Code();
		if(sale == null) {
			code.setCode(1);
			return code;
		}
		code.setCode(0);
		return code;
    } 
	
	@RequestMapping(value = "/signMessage",method = RequestMethod.POST)
	@ResponseBody
    public Sign sign(HttpServletRequest request,@RequestParam(value = "sale_id",required = false) int sale_id,
    		@RequestParam(value = "sign_latitude",required = false) String sign_latitude,
    		@RequestParam(value = "sign_longitude",required = false) String sign_longitude,
    		@RequestParam(value = "sign_location",required = false) String sign_location,
    		@RequestParam(value = "sign_time",required = false) String sign_time
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+sign_location);
		System.out.println("------>"+sign_time);
		Sign sign = new Sign();
		sign.setSale_id(sale_id);
		sign.setSign_latitude(sign_latitude);
		sign.setSign_longitude(sign_longitude);
		sign.setSign_location(sign_location);
		sign.setSign_time(sign_time);
		signService.add(sign);
		Sign sn = signService.findByTime(sign_time);
		if(sn != null) {
			return sn;
		}
		return null;
    }
	@RequestMapping(value = "/getsignMessage",method = RequestMethod.GET)
	@ResponseBody
    public List<Sign> getSign(HttpServletRequest request,@RequestParam(value = "sale_id",required = false) int sale_id
    		) {  
		List<Sign> list = signService.findBySaleId(sale_id);
		if(list != null & list.size() > 0) {
			return list;
		}
		return null;
    }
}
