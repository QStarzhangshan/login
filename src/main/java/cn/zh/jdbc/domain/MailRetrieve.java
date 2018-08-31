package cn.zh.jdbc.domain;

public class MailRetrieve {

	private int id;
	private String user_work_number;
	private String sid;
	private long out_time;
	
	
	
	public MailRetrieve(String user_work_number, String sid, long out_time) {
		super();
		this.user_work_number = user_work_number;
		this.sid = sid;
		this.out_time = out_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_work_number() {
		return user_work_number;
	}
	public void setUser_work_number(String user_work_number) {
		this.user_work_number = user_work_number;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public long getOut_time() {
		return out_time;
	}
	public void setOut_time(long out_time) {
		this.out_time = out_time;
	}
}
