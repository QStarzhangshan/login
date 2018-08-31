package cn.zh.jdbc.domain;

import java.util.Date;

public class Client {

	  private int client_id;
	  private int sale_id;
	  private String client_name;
	  private String client_owner_worknumber;
	  private int client_level;
	  private String client_number;
	  private String client_phone;
	  private String client_location;
	  private String client_location_detail;
	  private String client_note;
	  private String client_company_area;
	  private String client_department;
	  private String client_position;
	  private String client_industry;
	  private String client_create_time;
	  private String client_update_time;
	  
	  
	  
	public Client() {
		super();
	}
	public Client(String client_name) {
		super();
		this.client_name = client_name;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_owner_worknumber() {
		return client_owner_worknumber;
	}
	public void setClient_owner_worknumber(String client_owner_worknumber) {
		this.client_owner_worknumber = client_owner_worknumber;
	}
	public int getClient_level() {
		return client_level;
	}
	public void setClient_level(int client_level) {
		this.client_level = client_level;
	}
	public String getClient_number() {
		return client_number;
	}
	public void setClient_number(String client_number) {
		this.client_number = client_number;
	}
	public String getClient_phone() {
		return client_phone;
	}
	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}
	public String getClient_location() {
		return client_location;
	}
	public void setClient_location(String client_location) {
		this.client_location = client_location;
	}
	public String getClient_location_detail() {
		return client_location_detail;
	}
	public void setClient_location_detail(String client_location_detail) {
		this.client_location_detail = client_location_detail;
	}
	public String getClient_note() {
		return client_note;
	}
	public void setClient_note(String client_note) {
		this.client_note = client_note;
	}
	
	public String getClient_company_area() {
		return client_company_area;
	}
	public void setClient_company_area(String client_company_area) {
		this.client_company_area = client_company_area;
	}
	public String getClient_department() {
		return client_department;
	}
	public void setClient_department(String client_department) {
		this.client_department = client_department;
	}
	public String getClient_position() {
		return client_position;
	}
	public void setClient_position(String client_position) {
		this.client_position = client_position;
	}
	public String getClient_industry() {
		return client_industry;
	}
	public void setClient_industry(String client_industry) {
		this.client_industry = client_industry;
	}
	public String getClient_create_time() {
		return client_create_time;
	}
	public void setClient_create_time(String client_create_time) {
		this.client_create_time = client_create_time;
	}
	public String getClient_update_time() {
		return client_update_time;
	}
	public void setClient_update_time(String client_update_time) {
		this.client_update_time = client_update_time;
	}
	  
}
