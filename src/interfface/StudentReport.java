package interfface;

public class StudentReport {

	private IStudent student;
	public void show(IStudent student) {
		
		int count = student.classCount();
		System.out.println(count);
	}
}
