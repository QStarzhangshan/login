package cn.zh.jdbc.domain;

public class FaultyElevator {
	
	private String faulty_date;
	private String faulty_count;
	public String getFaulty_date() {
		return faulty_date;
	}
	public void setFaulty_date(String faulty_date) {
		this.faulty_date = faulty_date;
	}
	public String getFaulty_count() {
		return faulty_count;
	}
	public void setFaulty_count(String faulty_count) {
		this.faulty_count = faulty_count;
	}
	@Override
	public String toString() {
		return "FaultyElevator [faulty_date=" + faulty_date + ", faulty_count=" + faulty_count + "]";
	}
	
	
}
