package cleanMainfunction;

public class methods {

	public static void main(String[] args) {
		greetUser("John","Chen");
		String message = greetUser1("Lesley", "Chang");
		System.out.println(message);
	}
	
	// void if nothing return 
	public static void greetUser(String firstName, String lastName) {
		System.out.println("Hello " + firstName + " " + lastName);
	}
	// return statement
	public static String greetUser1(String firstName, String lastName) {
		return " Hello" + firstName + " " + lastName;
	}
}
