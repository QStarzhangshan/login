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

import cn.zh.jdbc.domain.Message;
import cn.zh.jdbc.domain.Sale;
import cn.zh.jdbc.domain.User;
import cn.zh.jdbc.domain.Visit;
import cn.zh.jdbc.service.MessageService;
import cn.zh.jdbc.service.SaleService;
import cn.zh.jdbc.service.UserService;
import cn.zh.jdbc.service.VisitService;

@RestController
public class ClientVisitResourceController {

	@Autowired
	SaleService saleService;
	
	@Autowired
	VisitService visitService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getAllByUserNumber",method = RequestMethod.GET)
	public List<Sale> getAllByUserNumber(HttpServletRequest request,@RequestParam(value = "user_worknumber",required = false) String user_worknumber
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+user_worknumber);
		List<Sale> list = saleService.findBySaleNumber(user_worknumber);
		if(list != null) {
			return list;
		}
		return list;
    }  
	
	@RequestMapping(value = "/findBySaleId",method = RequestMethod.GET)
	@ResponseBody
    public List<Visit> findBySaleId(HttpServletRequest request,@RequestParam(value = "sale_id",required = false) int sale_id
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+sale_id);
		List<Visit> list = visitService.findBySaleId(sale_id);
		if(list != null) {
			return list;
		}
		return null;
    }  
	
	@RequestMapping(value = "/addVisit",method = RequestMethod.POST)
	@ResponseBody
    public List<Visit> addVisit(HttpServletRequest request,@RequestParam(value = "sale_id",required = false) int sale_id,
    		@RequestParam(value = "visit_topic",required = false) String visit_topic,
    		@RequestParam(value = "client_name",required = false) String client_name,
    		@RequestParam(value = "visit_time",required = false) String visit_time,
    		@RequestParam(value = "visit_content",required = false) String visit_content,
    		@RequestParam(value = "visit_appointToId",required = false) int visit_appointToId,
    		@RequestParam(value = "visit_appointName",required = false) String visit_appointName,
    		@RequestParam(value = "visit_result",required = false) String visit_result,
    		@RequestParam(value = "visit_note",required = false) String visit_note
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+sale_id);
		System.out.println("----->"+visit_topic);
		System.out.println("----->"+client_name);
		System.out.println("----->"+visit_time);
		System.out.println("----->"+visit_content);
		System.out.println("----->"+visit_appointToId);
		System.out.println("----->"+visit_appointName);
		System.out.println("----->"+visit_result);
		System.out.println("----->"+visit_note);
		
		Visit visit = new Visit();
		visit.setSale_id(sale_id);
		visit.setVisit_topic(visit_topic);
		visit.setClient_name(client_name);
		visit.setVisit_time(visit_time);
		visit.setVisit_content(visit_content);
		visit.setVisit_appointToId(visit_appointToId);
		visit.setVisit_appointName(visit_appointName);
		visit.setVisit_result(visit_result);
		visit.setVisit_note(visit_note);
		visitService.add(visit);
		List<Visit> list = visitService.findBySaleId(sale_id);
		if(list != null) {
			Sale sale = saleService.findBySaleId(sale_id);
			User user = userService.findByUserWorkNumber(sale.getUser_worknumber());
			Message message = new Message();
			message.setSend_user(sale.getUser_worknumber());
			message.setSend_username(user.getUser_name());
			message.setSend_topic(visit_topic);
			message.setSendto_user(visit_appointToId+"");
			messageService.add(message);
			return list;
		}
		return null;
		
		
    }  
}
