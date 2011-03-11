
public class DoctorsOrders implements Record {
	private StringBuffer prescriptions;
	private StringBuffer labWork;
	private StringBuffer followUpInstr;
	private StringBuffer otherInstr;
	
	DoctorsOrders(StringBuffer prescriptions, StringBuffer labWork, StringBuffer followUpInstr, StringBuffer otherInstr){
		this.prescriptions = prescriptions;
		this.labWork = labWork;
		this.followUpInstr = followUpInstr;
		this.otherInstr = otherInstr;
	}
	
	public StringBuffer getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(StringBuffer prescriptions) {
		this.prescriptions = prescriptions;
	}
	public StringBuffer getLabWork() {
		return labWork;
	}
	public void setLabWork(StringBuffer labWork) {
		this.labWork = labWork;
	}
	public StringBuffer getFollowUpInstr() {
		return followUpInstr;
	}
	public void setFollowUpInstr(StringBuffer followUpInstr) {
		this.followUpInstr = followUpInstr;
	}
	public StringBuffer getOtherInstr() {
		return otherInstr;
	}
	public void setOtherInstr(StringBuffer otherInstr) {
		this.otherInstr = otherInstr;
	}
	
}