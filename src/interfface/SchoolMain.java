package interfface;

public class SchoolMain {

	public static void main(String[] args) {
		
		SchoolReport report = new SchoolReport();
		report.show(new School2019(12));
	}
}
