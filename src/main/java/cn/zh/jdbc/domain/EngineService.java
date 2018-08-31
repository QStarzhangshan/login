package cn.zh.jdbc.domain;

public class EngineService {

	private int id;
	private int service_id;
	private String user_number;
	private int tranction_machine;
	private int room_environment;
	private int encoder;
	private int brakespinparts;
	private int brakesclearance;
	private int speedlimiter;
	private int operating_device;
	
	
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
	public int getTranction_machine() {
		return tranction_machine;
	}
	public void setTranction_machine(int tranction_machine) {
		this.tranction_machine = tranction_machine;
	}
	public int getRoom_environment() {
		return room_environment;
	}
	public void setRoom_environment(int room_environment) {
		this.room_environment = room_environment;
	}
	public int getEncoder() {
		return encoder;
	}
	public void setEncoder(int encoder) {
		this.encoder = encoder;
	}
	
	
	public int getBrakespinparts() {
		return brakespinparts;
	}
	public void setBrakespinparts(int brakespinparts) {
		this.brakespinparts = brakespinparts;
	}
	public int getBrakesclearance() {
		return brakesclearance;
	}
	public void setBrakesclearance(int brakesclearance) {
		this.brakesclearance = brakesclearance;
	}
	public int getSpeedlimiter() {
		return speedlimiter;
	}
	public void setSpeedlimiter(int speedlimiter) {
		this.speedlimiter = speedlimiter;
	}
	public int getOperating_device() {
		return operating_device;
	}
	public void setOperating_device(int operating_device) {
		this.operating_device = operating_device;
	}
	@Override
	public String toString() {
		return "EngineService [id=" + id + ", service_id=" + service_id + ", user_number=" + user_number
				+ ", tranction_machine=" + tranction_machine + ", room_environment=" + room_environment + ", encoder="
				+ encoder + ", brakespinparts=" + brakespinparts + ", brakesclearance=" + brakesclearance
				+ ", speedlimiter=" + speedlimiter + ", operating_device=" + operating_device + "]";
	}
	
}
