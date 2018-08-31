package cn.zh.jdbc.domain;

public class Visit {

	private int id;
	private int sale_id;
	private String visit_topic;
	private String client_name;
	private String visit_time;
	private String visit_content;
	private int visit_appointToId;
	private String visit_appointName;
	private String visit_result;
	private String visit_note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}
	public String getVisit_content() {
		return visit_content;
	}
	public void setVisit_content(String visit_content) {
		this.visit_content = visit_content;
	}
	public String getVisit_result() {
		return visit_result;
	}
	public void setVisit_result(String visit_result) {
		this.visit_result = visit_result;
	}
	
	public String getVisit_topic() {
		return visit_topic;
	}
	public void setVisit_topic(String visit_topic) {
		this.visit_topic = visit_topic;
	}
	public int getVisit_appointToId() {
		return visit_appointToId;
	}
	public void setVisit_appointToId(int visit_appointToId) {
		this.visit_appointToId = visit_appointToId;
	}
	public String getVisit_appointName() {
		return visit_appointName;
	}
	public void setVisit_appointName(String visit_appointName) {
		this.visit_appointName = visit_appointName;
	}
	public String getVisit_note() {
		return visit_note;
	}
	public void setVisit_note(String visit_note) {
		this.visit_note = visit_note;
	}
	
}
