package cn.zh.jdbc.domain;

import java.util.Date;

public class Sale {

	private int sale_id;
	private String user_worknumber;
	private String client_name;
	private String sale_name;
	private String sale_level;
	private String sale_level_win;
	private Date sale_endtime;
	private String sale_node;
	private String sale_department;
	private String sale_opptunity_type;
	private String sale_source;
	private String sale_create_time;
	private String sale_update_time;
	
	
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getUser_worknumber() {
		return user_worknumber;
	}
	public void setUser_worknumber(String user_worknumber) {
		this.user_worknumber = user_worknumber;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getSale_name() {
		return sale_name;
	}
	public void setSale_name(String sale_name) {
		this.sale_name = sale_name;
	}
	public String getSale_level() {
		return sale_level;
	}
	public void setSale_level(String sale_level) {
		this.sale_level = sale_level;
	}
	public String getSale_level_win() {
		return sale_level_win;
	}
	public void setSale_level_win(String sale_level_win) {
		this.sale_level_win = sale_level_win;
	}
	public Date getSale_endtime() {
		return sale_endtime;
	}
	public void setSale_endtime(Date sale_endtime) {
		this.sale_endtime = sale_endtime;
	}
	public String getSale_node() {
		return sale_node;
	}
	public void setSale_node(String sale_node) {
		this.sale_node = sale_node;
	}
	public String getSale_department() {
		return sale_department;
	}
	public void setSale_department(String sale_department) {
		this.sale_department = sale_department;
	}
	public String getSale_opptunity_type() {
		return sale_opptunity_type;
	}
	public void setSale_opptunity_type(String sale_opptunity_type) {
		this.sale_opptunity_type = sale_opptunity_type;
	}
	public String getSale_source() {
		return sale_source;
	}
	public void setSale_source(String sale_source) {
		this.sale_source = sale_source;
	}
	public String getSale_create_time() {
		return sale_create_time;
	}
	public void setSale_create_time(String sale_create_time) {
		this.sale_create_time = sale_create_time;
	}
	public String getSale_update_time() {
		return sale_update_time;
	}
	public void setSale_update_time(String sale_update_time) {
		this.sale_update_time = sale_update_time;
	}
	
}
