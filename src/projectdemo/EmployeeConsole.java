package projectdemo;

import java.util.Scanner;

public class EmployeeConsole {

	private static Scanner scanner = new Scanner(System.in);
	
	public static double readValue(
			String title,
			int min,
			int max) {
		
		System.out.println("Please enter " + title + " between " + min + " to " + max +" : ");
		double value = scanner.nextDouble();
		while(value < min || value > max) {
			System.out.println("You must enter between " + min + " to " + max +" :");
			value = scanner.nextDouble();
		}
		return value;
	}
}
