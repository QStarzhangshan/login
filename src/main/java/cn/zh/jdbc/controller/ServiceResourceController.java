package cn.zh.jdbc.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.zh.jdbc.domain.CarWing;
import cn.zh.jdbc.domain.ClientByMap;
import cn.zh.jdbc.domain.Code;
import cn.zh.jdbc.domain.EngineService;
import cn.zh.jdbc.domain.Location;
import cn.zh.jdbc.domain.MaintenanceByMap;
import cn.zh.jdbc.domain.Pit;
import cn.zh.jdbc.domain.Repair;
import cn.zh.jdbc.domain.Service;
import cn.zh.jdbc.domain.WellRoad;
import cn.zh.jdbc.service.CarWingService;
import cn.zh.jdbc.service.EngineServiceService;
import cn.zh.jdbc.service.LocationService;
import cn.zh.jdbc.service.PitService;
import cn.zh.jdbc.service.RepairService;
import cn.zh.jdbc.service.ServiceService;
import cn.zh.jdbc.service.WellRoadService;

@RestController
public class ServiceResourceController {

	@Autowired
	private ServiceService serviceService;
	@Autowired
	private EngineServiceService engineServiceService;
	@Autowired
	private CarWingService carWingService;
	@Autowired
	private WellRoadService wellRoadService;
	@Autowired
	private PitService pitService;
	@Autowired
	private RepairService repairService;
	
	@Autowired
	private LocationService locationService;
	
	
	
	@RequestMapping(value = "/getService",method = RequestMethod.GET)
	@ResponseBody
    public List<Service> getService(HttpServletRequest request,@RequestParam(value = "user_number",required = false) String user_number){  
		List<Service> list = serviceService.findByServiceNumber(user_number);
		System.out.println(list);
		return list;
    }
	
	@RequestMapping(value = "/getLocation",method = RequestMethod.GET)
	@ResponseBody
    public List<Location> getLocation(HttpServletRequest request,HttpServletResponse resp){
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		List<Location> list = locationService.getLocation();
		return list;
    }
	@RequestMapping(value = "/getinfobyMap", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getinfobymap(){
		Map<String,Object> map = new HashMap<String,Object>();
		List<ClientByMap> list1 = locationService.getclientbymap();
		//List<MaintenanceByMap> list2 = locationService.getmaintenancebymap();
		map.put("clientbymap", list1);
		//map.put("maintenancebymap", list2);
		System.out.println(map);
		return map;
		
	};
	
	
	
	@RequestMapping(value = "/getServiceId",method = RequestMethod.GET)
	@ResponseBody
    public Service getServiceId(HttpServletRequest request,@RequestParam(value = "id",required = false) Integer id){  
		Service list = serviceService.findByServiceId(id);
		return list;
    }	
	
	@RequestMapping(value = "/likeSearch",method = RequestMethod.GET)
	@ResponseBody
    public List<Service> likeSearch(HttpServletRequest request,
    		@RequestParam(value = "usernumber",required = false) String usernumber,
    		@RequestParam(value = "elevator_number",required = false) String elevator_number){  
		List<Service> list = serviceService.likeSearch(usernumber, elevator_number);
		return list;
    }
	
	
	@RequestMapping(value = "/getCount",method = RequestMethod.GET)
	@ResponseBody
    public int getCount(HttpServletRequest request,
    		@RequestParam(value = "user_number",required = false) String user_number){  
		int count = serviceService.getCount(user_number);
		return count;
    }
	
	
	@RequestMapping(value = "/updateEngine",method = RequestMethod.POST)
	@ResponseBody
    public Code update(HttpServletRequest request,@RequestParam(value = "service_id",required = false) int service_id,
    		@RequestParam(value = "user_number",required = false) String user_number,
    		@RequestParam(value = "traction_machine",required = false) int traction_machine,
    		@RequestParam(value = "room_environment",required = false) int room_environment,
    		@RequestParam(value = "encoder",required = false) int encoder,
    		@RequestParam(value = "brakespinparts",required = false) int brakespinparts,
    		@RequestParam(value = "brakesclearance",required = false) int brakesclearance,
    		@RequestParam(value = "speedlimiter",required = false) int speedlimiter,
    		@RequestParam(value = "operating_device",required = false) int operating_device
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+service_id);
		System.out.println("------>"+user_number);
		EngineService engineService = new EngineService();
		engineService.setService_id(service_id);
		engineService.setUser_number(user_number);
		engineService.setTranction_machine(traction_machine);
		engineService.setRoom_environment(room_environment);
		engineService.setEncoder(encoder);
		engineService.setBrakespinparts(brakespinparts);
		engineService.setBrakesclearance(brakesclearance);
		engineService.setSpeedlimiter(speedlimiter);
		engineService.setOperating_device(operating_device);
		engineServiceService.update(engineService);
		Code code = new Code();
		code.setCode(1);
		return code;
    }  
	
	@RequestMapping(value = "/updateCarWing",method = RequestMethod.POST)
	@ResponseBody
    public Code updateCarWing(HttpServletRequest request,@RequestParam(value = "service_id",required = false) int service_id,
    		@RequestParam(value = "car_wing",required = false) int car_wing,
    		@RequestParam(value = "car_door",required = false) int car_door,
    		@RequestParam(value = "show_wing",required = false) int show_wing,
    		@RequestParam(value = "floor_wing",required = false) int floor_wing,
    		@RequestParam(value = "emergency_alarm",required = false) int emergency_alarm,
    		@RequestParam(value = "sentinel_plant",required = false) int sentinel_plant,
    		@RequestParam(value = "weigh",required = false) int weigh,
    		@RequestParam(value = "tank_guide_rail",required = false) int tank_guide_rail,
    		@RequestParam(value = "button_plate",required = false) int button_plate,
    		@RequestParam(value = "top_emergency_device",required = false) int top_emergency_device,
    		@RequestParam(value = "top_lubrication",required = false) int top_lubrication,
    		@RequestParam(value = "top_vibration",required = false) int top_vibration
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+service_id);
		CarWing carWing = new CarWing();
		carWing.setService_id(service_id);
		carWing.setCar_wing(car_wing);
		carWing.setCar_door(car_door);
		carWing.setShow(show_wing);
		carWing.setFloor(floor_wing);
		carWing.setEmergency_alarm(emergency_alarm);
		carWing.setSentinel_plant(sentinel_plant);
		carWing.setWeigh(weigh);
		carWing.setTank_guide_rail(tank_guide_rail);
		carWing.setButton_plate(button_plate);
		carWing.setTop_emergency_device(top_emergency_device);
		carWing.setTop_lubrication(top_lubrication);
		carWing.setTop_vibration(top_vibration);
		carWingService.update(carWing);
		Code code = new Code();
		code.setCode(1);
		return code;
    }
	
	@RequestMapping(value = "/updateWellRoad",method = RequestMethod.POST)
	@ResponseBody
    public Code updateWellRoad(HttpServletRequest request,@RequestParam(value = "service_id",required = false) int service_id,
    		@RequestParam(value = "houta_hall",required = false) int houta_hall,
    		@RequestParam(value = "gate_check",required = false) int gate_check,
    		@RequestParam(value = "gate_operation",required = false) int gate_operation,
    		@RequestParam(value = "gate_interlocking",required = false) int gate_interlocking,
    		@RequestParam(value = "well_cable",required = false) int well_cable,
    		@RequestParam(value = "limit_speed_switch",required = false) int limit_speed_switch,
    		@RequestParam(value = "door_plank",required = false) int door_plank
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+service_id);
		WellRoad wellRoad = new WellRoad();
		wellRoad.setService_id(service_id);
		wellRoad.setHouta_hall(houta_hall);
		wellRoad.setGate_check(gate_check);
		wellRoad.setGate_operation(gate_operation);
		wellRoad.setGate_interlocking(gate_interlocking);
		wellRoad.setWell_cable(well_cable);
		wellRoad.setLimit_speed_switch(limit_speed_switch);
		wellRoad.setDoor_plank(door_plank);
		wellRoadService.update(wellRoad);
		Code code = new Code();
		code.setCode(1);
		return code;
    }
	
	
	@RequestMapping(value = "/updatePit",method = RequestMethod.POST)
	@ResponseBody
    public Code updatePit(HttpServletRequest request,@RequestParam(value = "service_id",required = false) int service_id,
    		@RequestParam(value = "light",required = false) int light,
    		@RequestParam(value = "sudden_stop_switch",required = false) int sudden_stop_switch,
    		@RequestParam(value = "rovolve_member",required = false) int rovolve_member,
    		@RequestParam(value = "pond",required = false) int pond
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+service_id);
		Pit pit = new Pit();
		pit.setService_id(service_id);
		pit.setLight(light);
		pit.setSudden_stop_switch(sudden_stop_switch);
		pit.setRovolve_member(rovolve_member);
		pit.setPond(pond);
		pitService.update(pit);
		Code code = new Code();
		code.setCode(1);
		return code;
    }
	
	@RequestMapping(value = "/updateRepair",method = RequestMethod.POST)
	@ResponseBody
    public Code updateRepair(@RequestParam(value = "user_number",required = false) String user_number,
    		@RequestParam(value = "traction_machine",required = false) int traction_machine,
    		@RequestParam(value = "room_environment",required = false) int room_environment,
    		@RequestParam(value = "encoder",required = false) int encoder,
    		@RequestParam(value = "brakespinparts",required = false) int brakespinparts,
    		@RequestParam(value = "brakesclearance",required = false) int brakesclearance,
    		@RequestParam(value = "speedlimiter",required = false) int speedlimiter,
    		@RequestParam(value = "operating_device",required = false) int operating_device,
    		@RequestParam(value = "car_wing",required = false) int car_wing,
    		@RequestParam(value = "car_door",required = false) int car_door,
    		@RequestParam(value = "show_wing",required = false) int show,
    		@RequestParam(value = "floor_wing",required = false) int floor,
    		@RequestParam(value = "emergency_alarm",required = false) int emergency_alarm,
    		@RequestParam(value = "sentinel_plant",required = false) int sentinel_plant,
    		@RequestParam(value = "weigh",required = false) int weigh,
    		@RequestParam(value = "tank_guide_rail",required = false) int tank_guide_rail,
    		@RequestParam(value = "button_plate",required = false) int button_plate,
    		@RequestParam(value = "top_emergency_device",required = false) int top_emergency_device,
    		@RequestParam(value = "top_lubrication",required = false) int top_lubrication,
    		@RequestParam(value = "top_vibration",required = false) int top_vibration,
    		@RequestParam(value = "houta_hall",required = false) int houta_hall,
    		@RequestParam(value = "gate_check",required = false) int gate_check,
    		@RequestParam(value = "gate_operation",required = false) int gate_operation,
    		@RequestParam(value = "gate_interlocking",required = false) int gate_interlocking,
    		@RequestParam(value = "well_cable",required = false) int well_cable,
    		@RequestParam(value = "limit_speed_switch",required = false) int limit_speed_switch,
    		@RequestParam(value = "door_plank",required = false) int door_plank,
    		@RequestParam(value = "light",required = false) int light,
    		@RequestParam(value = "sudden_stop_switch",required = false) int sudden_stop_switch,
    		@RequestParam(value = "rovolve_member",required = false) int rovolve_member,
    		@RequestParam(value = "pond",required = false) int pond
    		) throws NoSuchAlgorithmException{  
		System.out.println("----->"+user_number);
		Repair repair = new Repair();
		repair.setUser_number(user_number);
		repair.setTranction_machine(traction_machine);
		repair.setRoom_environment(room_environment);
		repair.setEncoder(encoder);
		repair.setBrakespinparts(brakespinparts);
		repair.setBrakesclearance(brakesclearance);
		repair.setSpeedlimiter(speedlimiter);
		repair.setOperating_device(operating_device);
		repair.setCar_wing(car_wing);
		repair.setCar_door(car_door);
		repair.setShow(show);
		repair.setFloor(floor);
		repair.setEmergency_alarm(emergency_alarm);
		repair.setSentinel_plant(sentinel_plant);
		repair.setWeigh(weigh);
		repair.setTank_guide_rail(tank_guide_rail);
		repair.setButton_plate(button_plate);
		repair.setTop_emergency_device(top_emergency_device);
		repair.setTop_lubrication(top_lubrication);
		repair.setTop_vibration(top_vibration);
		repair.setHouta_hall(houta_hall);
		repair.setGate_check(gate_check);
		repair.setGate_operation(gate_operation);
		repair.setGate_interlocking(gate_interlocking);
		repair.setWell_cable(well_cable);
		repair.setLimit_speed_switch(limit_speed_switch);
		repair.setDoor_plank(door_plank);
		repair.setLight(light);
		repair.setSudden_stop_switch(sudden_stop_switch);
		repair.setRovolve_member(rovolve_member);
		repair.setPond(pond);
		repairService.update(repair);
		Code code = new Code();
		code.setCode(1);
		return code;
    }
}
