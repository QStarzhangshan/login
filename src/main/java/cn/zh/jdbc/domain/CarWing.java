package cn.zh.jdbc.domain;

public class CarWing {

	private int id;
	private int service_id;	
	private String user_number;
	private int car_wing;
	private int car_door;
	private int show;
	private int floor;
	private int emergency_alarm;
	private int sentinel_plant;
	private int weigh;
	private int tank_guide_rail;
	private int button_plate;
	private int top_emergency_device;
	private int top_lubrication;
	private int top_vibration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public int getCar_wing() {
		return car_wing;
	}
	public void setCar_wing(int car_wing) {
		this.car_wing = car_wing;
	}
	public int getCar_door() {
		return car_door;
	}
	public void setCar_door(int car_door) {
		this.car_door = car_door;
	}
	public int getShow() {
		return show;
	}
	public void setShow(int show) {
		this.show = show;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getEmergency_alarm() {
		return emergency_alarm;
	}
	public void setEmergency_alarm(int emergency_alarm) {
		this.emergency_alarm = emergency_alarm;
	}
	public int getSentinel_plant() {
		return sentinel_plant;
	}
	public void setSentinel_plant(int sentinel_plant) {
		this.sentinel_plant = sentinel_plant;
	}
	public int getWeigh() {
		return weigh;
	}
	public void setWeigh(int weigh) {
		this.weigh = weigh;
	}
	public int getTank_guide_rail() {
		return tank_guide_rail;
	}
	public void setTank_guide_rail(int tank_guide_rail) {
		this.tank_guide_rail = tank_guide_rail;
	}
	public int getButton_plate() {
		return button_plate;
	}
	public void setButton_plate(int button_plate) {
		this.button_plate = button_plate;
	}
	public int getTop_emergency_device() {
		return top_emergency_device;
	}
	public void setTop_emergency_device(int top_emergency_device) {
		this.top_emergency_device = top_emergency_device;
	}
	public int getTop_lubrication() {
		return top_lubrication;
	}
	public void setTop_lubrication(int top_lubrication) {
		this.top_lubrication = top_lubrication;
	}
	public int getTop_vibration() {
		return top_vibration;
	}
	public void setTop_vibration(int top_vibration) {
		this.top_vibration = top_vibration;
	}
	@Override
	public String toString() {
		return "CarWing [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number + ", car_wing="
				+ car_wing + ", car_door=" + car_door + ", show=" + show + ", floor=" + floor + ", emergency_alarm="
				+ emergency_alarm + ", sentinel_plant=" + sentinel_plant + ", weigh=" + weigh + ", tank_guide_rail="
				+ tank_guide_rail + ", button_plate=" + button_plate + ", top_emergency_device=" + top_emergency_device
				+ ", top_lubrication=" + top_lubrication + ", top_vibration=" + top_vibration + "]";
	}
	
}
