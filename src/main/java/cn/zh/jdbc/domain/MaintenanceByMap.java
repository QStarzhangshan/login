package cn.zh.jdbc.domain;

public class MaintenanceByMap {

	private String user_name;
	private String phonenumber;
	private Integer status;
	private String longitude;
	private String latitude;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "MaintenanceByMap [user_name=" + user_name + ", phonenumber=" + phonenumber + ", status=" + status
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
	
}
