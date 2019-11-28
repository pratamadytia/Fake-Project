import java.util.Date;


public class ScheduleDoctor {
	public ScheduleDoctor(){}
	
	public ScheduleDoctor(String scheduleId, Date scheduleDate,
			Date scheduleTime, Doctor doctor) {
		this.scheduleId = scheduleId;
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
		this.doctor = doctor;
	}

	private String scheduleId;
	private Date scheduleDate;
	private Date scheduleTime;
	private Doctor doctor;
	
	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Date getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void updateScheduleDoctor(){}
	
	public ScheduleDoctor getScheduleDoctor(){
		return this;
	}
}
