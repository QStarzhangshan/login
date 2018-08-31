package cn.zh.jdbc.domain;

public class MaintenanceStaff {
	
	private String staff_name;
	private String staff_area;
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_area() {
		return staff_area;
	}
	public void setStaff_area(String staff_area) {
		this.staff_area = staff_area;
	}
	@Override
	public String toString() {
		return "MaintenanceStaff [staff_name=" + staff_name + ", staff_area=" + staff_area + "]";
	}
	
	
}
