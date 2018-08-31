package cn.zh.jdbc.domain;

public class ClientByMap {
	private String client_name;
	private String maintenance_company;
	private String task_createtime;
	private String user_name;
	private String phonenumber;
	private String registration_code;
	private Integer status;
	private String contact_name;
	private String contact_phone;
	private String address;
	private String latitude;
	private String longitude;

	
	
	public String getClient_name() {
		return client_name;
	}


	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}


	public String getMaintenance_company() {
		return maintenance_company;
	}


	public void setMaintenance_company(String maintenance_company) {
		this.maintenance_company = maintenance_company;
	}


	public String getTask_createtime() {
		return task_createtime;
	}


	public void setTask_createtime(String task_createtime) {
		this.task_createtime = task_createtime;
	}


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


	public String getRegistration_code() {
		return registration_code;
	}


	public void setRegistration_code(String registration_code) {
		this.registration_code = registration_code;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getContact_name() {
		return contact_name;
	}


	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}


	public String getContact_phone() {
		return contact_phone;
	}


	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	@Override
	public String toString() {
		return "ClientByMap [client_name=" + client_name + ", maintenance_company=" + maintenance_company
				+ ", task_createtime=" + task_createtime + ", user_name=" + user_name + ", phonenumber=" + phonenumber
				+ ", registration_code=" + registration_code + ", status=" + status + ", contact_name=" + contact_name
				+ ", contact_phone=" + contact_phone + ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}





	
	
	
}
