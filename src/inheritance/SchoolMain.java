package inheritance;

public class SchoolMain {
	public static void main(String[] args) {
		

		SchoolStudent student1 = new SchoolStudent(10,7);
		student1.printDetail();
		SchoolTeacher teacher1 = new SchoolTeacher(1,24);
		teacher1.printDetail();
		SchoolStudent student2 = new SchoolStudent(11,7);
		student2.printDetail();
		System.out.println(student2.toString());
		
	}

}
