package smallprojects;

import java.text.NumberFormat;
import java.util.Scanner;

public class AdvanceCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Principal (Enter between 1K to 1M): ");
		int Principal = scanner.nextInt();
		while(Principal < 1_000 || Principal >1_000_000) {
			System.out.println("You must enter between 1K to 1M");
			System.out.print("Principal: ");
			Principal = scanner.nextInt();
		}
		//System.out.println(Principal);
		System.out.print("Annual Interest Rate:");
		//float is better than double 
		double annualRate = scanner.nextDouble();
		while(annualRate < 0 || annualRate > 5) {
			System.out.println("Enter between 0 to 5");
			System.out.print("Annual Interest Rate: ");
			annualRate = scanner.nextDouble();
		}
		double monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR; 
		//System.out.println(AnnualRate);
		System.out.print	("Period (Years):");
		int Year = scanner.nextInt();
		while(Year <0 || Year > 10) {
			System.out.println("You must enter between 0 to 10: ");
			System.out.print("Year");
			Year = scanner.nextInt();
		}
		int numberOfPayment = Year * MONTHS_IN_YEAR;
		
		double mortgage = Principal * (monthlyRate *Math.pow(1+ monthlyRate, numberOfPayment))
									/ (Math.pow(1+ monthlyRate, numberOfPayment) -1 );
		
		String result = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + result);
		//NumberFormat res =  NumberFormat.getCurrencyInstance();
		//String Mortgage = res.getCurrency(cal);
	}

}
