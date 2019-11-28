
public abstract class Staff {
	
	public Staff() {}
	
	public Staff(String staffId, String staffName, String staffEmail,
			String staffPassword, String staffAddress, String staffWorkingTime) {
		
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffEmail = staffEmail;
		this.staffPassword = staffPassword;
		this.staffAddress = staffAddress;
		this.staffWorkingTime = staffWorkingTime;
	}
	
	private String staffId;
	private String staffName;
	private String staffEmail;
	private String staffPassword;
	private String staffAddress;
	private String staffWorkingTime;
	
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public String getStaffWorkingTime() {
		return staffWorkingTime;
	}
	public void setStaffWorkingTime(String staffWorkingTime) {
		this.staffWorkingTime = staffWorkingTime;
	}
	
	
}
