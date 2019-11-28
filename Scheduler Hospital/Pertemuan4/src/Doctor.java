
public class Doctor extends Staff {
	
	
	public Doctor(String staffId, String staffName, String staffEmail,
			String staffPassword, String staffAddress, String staffWorkingTime) {
		super(staffId, staffName, staffEmail, staffPassword, staffAddress,
				staffWorkingTime);
	}

	public Doctor() {}

	private String specialistName;
	
	public String getSpecialistName() {
		return specialistName;
	}

	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}

	public void registerSchedule(){}
	public void checkDoctorSchedule(){}
}
