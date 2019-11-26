package interfface;

public class SchoolReport {

	private ISchool number;
	
	public void show(ISchool number) {
		int total = number.SchoolCount();
		System.out.println("Total number school: " + total);
	}
}
