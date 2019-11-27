package interfface;

import java.util.Scanner;

public class BookConsole {

	private String title;
	private int min;
	private int max;
	private static Scanner scanner = new Scanner(System.in);
	
	public BookConsole() {}
	
	public static double readNumber(String title, int min , int max) {
		System.out.println("Enter the number of total books: ");
		double result = scanner.nextDouble();
		return result;
	}
}
