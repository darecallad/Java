package projectdemo;

public class StudentReport {

	private StudentCal calculator;
	
	public StudentReport(StudentCal calculator) {
		// TODO Auto-generated constructor stub
		this.calculator = calculator;
	}
	
	public void printResult() {
		double result = calculator.getLeftHours();
		System.out.println("Left time: " + result + " hours.");
	}

}
