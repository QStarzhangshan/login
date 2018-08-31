package cn.zh.jdbc.domain;

public class WellRoad {
	
	private int id;
	private int service_id;
	private String user_number;
	private int houta_hall;
	private int gate_check;
	private int gate_operation;
	private int gate_interlocking;
	private int well_cable;
	private int limit_speed_switch;
	private int door_plank;
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
	public int getHouta_hall() {
		return houta_hall;
	}
	public void setHouta_hall(int houta_hall) {
		this.houta_hall = houta_hall;
	}
	public int getGate_check() {
		return gate_check;
	}
	public void setGate_check(int gate_check) {
		this.gate_check = gate_check;
	}
	public int getGate_operation() {
		return gate_operation;
	}
	public void setGate_operation(int gate_operation) {
		this.gate_operation = gate_operation;
	}
	public int getGate_interlocking() {
		return gate_interlocking;
	}
	public void setGate_interlocking(int gate_interlocking) {
		this.gate_interlocking = gate_interlocking;
	}
	public int getWell_cable() {
		return well_cable;
	}
	public void setWell_cable(int well_cable) {
		this.well_cable = well_cable;
	}
	public int getLimit_speed_switch() {
		return limit_speed_switch;
	}
	public void setLimit_speed_switch(int limit_speed_switch) {
		this.limit_speed_switch = limit_speed_switch;
	}
	public int getDoor_plank() {
		return door_plank;
	}
	public void setDoor_plank(int door_plank) {
		this.door_plank = door_plank;
	}
	@Override
	public String toString() {
		return "WellRoad [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number + ", houta_hall="
				+ houta_hall + ", gate_check=" + gate_check + ", gate_operation=" + gate_operation
				+ ", gate_interlocking=" + gate_interlocking + ", well_cable=" + well_cable + ", limit_speed_switch="
				+ limit_speed_switch + ", door_plank=" + door_plank + "]";
	}
	
	
	

}
