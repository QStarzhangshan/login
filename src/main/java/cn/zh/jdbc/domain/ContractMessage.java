package cn.zh.jdbc.domain;

public class ContractMessage {

	private int id;
	private String user_worknumber;
	private String contract_topic;
	private String client_name;
	private String amount;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_worknumber() {
		return user_worknumber;
	}
	public void setUser_worknumber(String user_worknumber) {
		this.user_worknumber = user_worknumber;
	}
	public String getContract_topic() {
		return contract_topic;
	}
	public void setContract_topic(String contract_topic) {
		this.contract_topic = contract_topic;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
