package cn.zh.jdbc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zh.jdbc.domain.ElevatorNumber;
import cn.zh.jdbc.domain.ElevatorRate;
import cn.zh.jdbc.domain.FaultyElevator;
import cn.zh.jdbc.domain.Index;
import cn.zh.jdbc.domain.MaintenanceElevator;
import cn.zh.jdbc.domain.MaintenanceStaff;
import cn.zh.jdbc.service.IndexService;

@RestController
public class IndexController {

	@Autowired
	IndexService indexService;
	
	
	
	@RequestMapping(value="/getmaintenanceElevator",method=RequestMethod.GET)
	@ResponseBody
	public List<MaintenanceElevator> getmaintenanceElevator(@RequestParam(value = "city",required = false) String city){
		List<MaintenanceElevator> list = indexService.getmaintenanceElevator(city);
		for(MaintenanceElevator me : list) {
			System.out.println(me);
		}
		System.out.println(list);
		return list;
		
	}
	
	@RequestMapping(value="/getfaultyelevator", method=RequestMethod.GET )
	@ResponseBody
	public List<FaultyElevator> getfaultyelevator(@RequestParam(value="city", required=false) String city){
		List<FaultyElevator> list = indexService.getfaultyelevator(city);
		System.out.println(list);
		return list;
		
	}
	@RequestMapping(value="/getmaintenancestaff", method=RequestMethod.GET)
	@ResponseBody
	public List<MaintenanceStaff> getmaintenancestaff(@RequestParam(value = "city",required=false) String city){
		List<MaintenanceStaff> list = indexService.getmaintenancestaff(city);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value= "/getelevatornumber", method=RequestMethod.GET)
	@ResponseBody
	public List<ElevatorRate> getelevatornumber(@RequestParam(value="city",required=false) String city){
		List<ElevatorRate> list = indexService.getelevatornumber(city);
		//map = indexService.getelevatornumber(city);
		//List<ElevatorNumber> list = indexService.getelevatornumber(city);
		//System.out.println("------------"+map);
		return list;
	}
	
	@RequestMapping(value="/getindex",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getindex( HttpServletRequest request,@RequestParam(value="city",required=false)String city) throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Integer> map1 = new HashMap<String,Integer>();
		//city = URLDecoder.decode(request.getParameter("city"),"UTF-8");
		List<MaintenanceElevator> maintenancelist = indexService.getmaintenanceElevator(city);
		List<FaultyElevator> faultylist = indexService.getfaultyelevator(city);
		List<MaintenanceStaff> stafflist = indexService.getmaintenancestaff(city);
		List<ElevatorRate> ratelist = indexService.getelevatornumber(city);
		
		map.put("ratelist", ratelist);
		map.put("maintenancelist", maintenancelist);
		map.put("faultylist", faultylist);
		map.put("stafflist", stafflist);
		System.out.println(city);

		return map;
	}
}

