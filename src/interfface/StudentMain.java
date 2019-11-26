package interfface;

public class StudentMain {

	public static void main(String[] args) {
		
		StudentReport report = new StudentReport();
		report.show(new Student2019(10));
		
		report.show(new Student2020(13));
	}
}
