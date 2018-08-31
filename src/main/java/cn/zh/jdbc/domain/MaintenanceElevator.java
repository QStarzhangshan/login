package cn.zh.jdbc.domain;

public class MaintenanceElevator {
	
	private String maintenance_date;
	private String maintenance_count;
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
	@Override
	public String toString() {
		return "MaintenanceElevator [maintenance_date=" + maintenance_date + ", maintenance_count=" + maintenance_count
				+ "]";
	}
	
	
	
}
