package cn.zh.jdbc.domain;

public class Message {

	private int id;
	private String send_user;
	private String send_username;
	private String send_topic;
	private String sendto_user;
	private String isRead;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSend_user() {
		return send_user;
	}
	public void setSend_user(String send_user) {
		this.send_user = send_user;
	}
	
	public String getSend_username() {
		return send_username;
	}
	public void setSend_username(String send_username) {
		this.send_username = send_username;
	}
	public String getSend_topic() {
		return send_topic;
	}
	public void setSend_topic(String send_topic) {
		this.send_topic = send_topic;
	}
	public String getSendto_user() {
		return sendto_user;
	}
	public void setSendto_user(String sendto_user) {
		this.sendto_user = sendto_user;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
}
