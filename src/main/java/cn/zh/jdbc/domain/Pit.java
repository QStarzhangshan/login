package cn.zh.jdbc.domain;

public class Pit {

	private int id;
	private int service_id;
	private String user_number;
	private int light;
	private int sudden_stop_switch;
	private int rovolve_member;
	private int pond;
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
	public int getLight() {
		return light;
	}
	public void setLight(int light) {
		this.light = light;
	}
	public int getSudden_stop_switch() {
		return sudden_stop_switch;
	}
	public void setSudden_stop_switch(int sudden_stop_switch) {
		this.sudden_stop_switch = sudden_stop_switch;
	}
	public int getRovolve_member() {
		return rovolve_member;
	}
	public void setRovolve_member(int rovolve_member) {
		this.rovolve_member = rovolve_member;
	}
	public int getPond() {
		return pond;
	}
	public void setPond(int pond) {
		this.pond = pond;
	}
	@Override
	public String toString() {
		return "Pit [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number + ", light=" + light
				+ ", sudden_stop_switch=" + sudden_stop_switch + ", rovolve_member=" + rovolve_member + ", pond=" + pond
				+ "]";
	}
	
	
}
