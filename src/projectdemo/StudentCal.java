package projectdemo;

public class StudentCal {
	
	private double studyingHours;
	private double finishHours;

	public StudentCal(double studyingHours, double finishHours) {
		// TODO Auto-generated constructor stub
		this.studyingHours = studyingHours;
		this.finishHours = finishHours;
	}
	
	public double getLeftHours () {
		return (studyingHours - finishHours);
	}

}
