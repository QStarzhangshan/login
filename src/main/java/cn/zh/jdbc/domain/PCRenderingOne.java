package cn.zh.jdbc.domain;

import java.util.List;

public class PCRenderingOne {
	
	private List<ElevatorRate> elevatorRateslist;
	private List<MaintenanceElevator> maintenanceElevatorlist;
	private List<FaultyElevator> faultyElevatorlist;
	private List<MaintenanceStaff> maintenanceStafflist;
	public List<ElevatorRate> getElevatorRateslist() {
		return elevatorRateslist;
	}
	public void setElevatorRateslist(List<ElevatorRate> elevatorRateslist) {
		this.elevatorRateslist = elevatorRateslist;
	}
	public List<MaintenanceElevator> getMaintenanceElevatorlist() {
		return maintenanceElevatorlist;
	}
	public void setMaintenanceElevatorlist(List<MaintenanceElevator> maintenanceElevatorlist) {
		this.maintenanceElevatorlist = maintenanceElevatorlist;
	}
	public List<FaultyElevator> getFaultyElevatorlist() {
		return faultyElevatorlist;
	}
	public void setFaultyElevatorlist(List<FaultyElevator> faultyElevatorlist) {
		this.faultyElevatorlist = faultyElevatorlist;
	}
	public List<MaintenanceStaff> getMaintenanceStafflist() {
		return maintenanceStafflist;
	}
	public void setMaintenanceStafflist(List<MaintenanceStaff> maintenanceStafflist) {
		this.maintenanceStafflist = maintenanceStafflist;
	}
	@Override
	public String toString() {
		return "PCRenderingOne [elevatorRateslist=" + elevatorRateslist + ", maintenanceElevatorlist="
				+ maintenanceElevatorlist + ", faultyElevatorlist=" + faultyElevatorlist + ", maintenanceStafflist="
				+ maintenanceStafflist + "]";
	}
	
	
	
}
