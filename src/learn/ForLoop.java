package learn;

import java.util.Scanner;

public class ForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// increment 
		for(int i = 0; i<5; i++) {
			System.out.println("HELLO");
			
			// while using when you dont know how many times you need to run
			Scanner scanner = new Scanner(System.in);
			String input = "";
			while(input.equals("quit")) {
				System.out.println("Input: ");
				input = scanner.next().toLowerCase();
				if (!input.equals("quit")) {
				System.out.println(input);
				}
				// while(true)
				// if (input.equals("pass"))
				// continue;
				// if (input.equals("quit"))
				//	break;
				//	System.out.println(input);
			}
		}
	}

}
