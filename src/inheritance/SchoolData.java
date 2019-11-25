package inheritance;

public abstract class SchoolData {
	
	private int number;
	private int age;
	
	public SchoolData(int number, int age) {
		this.number = number;
		this.age = age;
	}
	
	public void printDetail() {
		System.out.println("Number is: "+ number);
		System.out.println("Age is: " + age);
	}

}
