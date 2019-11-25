package learn;

public class SwitchStatement {

	public static void main(String[] args) {
		
		// String, integer, double, char....etc
		String role = "admin";
		switch(role) {
		case "admin":
			System.out.println("you are admin");
			break;
		case "moderator":
			System.out.println("you are moderator");
			break;
		default:
			System.out.println("you are a guest");
		}
	}
}
