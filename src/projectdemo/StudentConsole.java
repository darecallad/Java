package projectdemo;

import java.util.Scanner;

public class StudentConsole {

	private static Scanner scanner = new Scanner(System.in);
	public static double readValue(String title, int min, int max) {
		// TODO Auto-generated method stub
		System.out.println("Please Enter " + title + " between " + min + " and " + max+ " : ");
		double value = scanner.nextDouble();
		while(value < min || value > max) {
			System.out.println("you must enter between " + min + " and " + max +" : ");
			value = scanner.nextDouble();
		}
		return value;
	}

}
