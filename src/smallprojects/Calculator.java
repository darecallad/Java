package smallprojects;

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// avoid magic number
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Principal:");
		int Principal = scanner.nextInt();
		//System.out.println(Principal);
		System.out.print("Annual Interest Rate:");
		//float is better than double 
		double annualRate = scanner.nextDouble();
		double monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR; 
		//System.out.println(AnnualRate);
		System.out.print	("Period (Years):");
		int Year = scanner.nextInt();
		int numberOfPayment = Year * MONTHS_IN_YEAR;
		
		double mortgage = Principal * (monthlyRate *Math.pow(1+ monthlyRate, numberOfPayment))
									/ (Math.pow(1+ monthlyRate, numberOfPayment) -1 );
		
		String result = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + result);
		//NumberFormat res =  NumberFormat.getCurrencyInstance();
		//String Mortgage = res.getCurrency(cal);
	}

}
