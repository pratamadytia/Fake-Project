
public class Receptionist extends Staff {
	
	public Receptionist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Receptionist(String staffId, String staffName, String staffEmail,
			String staffPassword, String staffAddress, String staffWorkingTime) {
		super(staffId, staffName, staffEmail, staffPassword, staffAddress,
				staffWorkingTime);
		// TODO Auto-generated constructor stub
	}
	
	public void approveCheckUpSchedule(){}
	public void checkDoctorSchedule(){}
	public void registerPatient(){}
}
