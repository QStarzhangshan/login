package cn.zh.jdbc.domain;

public class Index {
	
	private String normal_rate;
	private String maintenance_rate;
	private String faulty_rate;
	private String maintenance_date;
	private String maintenance_count;
	private String faulty_date;
	private String faulty_count;
	private String maintenance_staff;
	private String maintenance_area;
	public String getNormal_rate() {
		return normal_rate;
	}
	public void setNormal_rate(String normal_rate) {
		this.normal_rate = normal_rate;
	}
	public String getMaintenance_rate() {
		return maintenance_rate;
	}
	public void setMaintenance_rate(String maintenance_rate) {
		this.maintenance_rate = maintenance_rate;
	}
	public String getFaulty_rate() {
		return faulty_rate;
	}
	public void setFaulty_rate(String faulty_rate) {
		this.faulty_rate = faulty_rate;
	}
	public String getMaintenance_date() {
		return maintenance_date;
	}
	public void setMaintenance_date(String maintenance_date) {
		this.maintenance_date = maintenance_date;
	}
	public String getMaintenance_count() {
		return maintenance_count;
	}
	public void setMaintenance_count(String maintenance_count) {
		this.maintenance_count = maintenance_count;
	}
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
	public String getMaintenance_staff() {
		return maintenance_staff;
	}
	public void setMaintenance_staff(String maintenance_staff) {
		this.maintenance_staff = maintenance_staff;
	}
	public String getMaintenance_area() {
		return maintenance_area;
	}
	public void setMaintenance_area(String maintenance_area) {
		this.maintenance_area = maintenance_area;
	}
	@Override
	public String toString() {
		return "Index [normal_rate=" + normal_rate + ", maintenance_rate=" + maintenance_rate + ", faulty_rate="
				+ faulty_rate + ", maintenance_date=" + maintenance_date + ", maintenance_count=" + maintenance_count
				+ ", faulty_date=" + faulty_date + ", faulty_count=" + faulty_count + ", maintenance_staff="
				+ maintenance_staff + ", maintenance_area=" + maintenance_area + "]";
	}
	
	
}
