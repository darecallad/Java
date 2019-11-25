package projectdemo;

public class StudentMain {
	
	public static void main(String[] args) {
		
		double studyingHours = StudentConsole.readValue("Studying Hours: ", 0 , 20);
		double finishHours = StudentConsole.readValue("Finished Hours: ", 0 , 20);
		StudentCal calculator = new StudentCal(studyingHours,finishHours);
		StudentReport report = new StudentReport(calculator);
		report.printResult();
	}

}
