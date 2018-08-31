package cn.zh.jdbc.domain;

public class ElevatorNumber  {
	
	public String normal_count;
	public String faulty_count;
	public String maintenance_count;
	public String getNormal_count() {
		return normal_count;
	}
	public void setNormal_count(String normal_count) {
		this.normal_count = normal_count;
	}
	public String getFaulty_count() {
		return faulty_count;
	}
	public void setFaulty_count(String faulty_count) {
		this.faulty_count = faulty_count;
	}
	public String getMaintenance_count() {
		return maintenance_count;
	}
	public void setMaintenance_count(String maintenance_count) {
		this.maintenance_count = maintenance_count;
	}
	@Override
	public String toString() {
		return "ElevatorNumber [normal_count=" + normal_count + ", faulty_count=" + faulty_count
				+ ", maintenance_count=" + maintenance_count + "]";
	}
	
	
	
}