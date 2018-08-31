package cn.zh.jdbc.domain;

public class Sign {

	private int sign_id;
	private int sale_id;
	private String sign_latitude;
	private String sign_longitude;
	private String sign_location;
	private String sign_time;
	public int getSign_id() {
		return sign_id;
	}
	public void setSign_id(int sign_id) {
		this.sign_id = sign_id;
	}
	
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getSign_latitude() {
		return sign_latitude;
	}
	public void setSign_latitude(String sign_latitude) {
		this.sign_latitude = sign_latitude;
	}
	public String getSign_longitude() {
		return sign_longitude;
	}
	public void setSign_longitude(String sign_longitude) {
		this.sign_longitude = sign_longitude;
	}
	public String getSign_location() {
		return sign_location;
	}
	public void setSign_location(String sign_location) {
		this.sign_location = sign_location;
	}
	public String getSign_time() {
		return sign_time;
	}
	public void setSign_time(String sign_time) {
		this.sign_time = sign_time;
	}
	
}
