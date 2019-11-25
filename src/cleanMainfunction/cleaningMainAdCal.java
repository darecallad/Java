package cleanMainfunction;

import java.text.NumberFormat;
import java.util.Scanner;

public class cleaningMainAdCal {
	public static void main (String[] args) {
		int Principal = (int)readNumber("Principal",1000,1_000_000);
		float annualRate = (float)readNumber("AnnualRate",0,5);
		byte Year = (byte)readNumber("Year",0,5);
		double mortgage = calmortgage(Principal,annualRate,Year);
		String result = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + result);
	}
	public static double readNumber(String title, double min, double max) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(title + " (Enter between "+ min +" and "+ max + ")");
		double value = scanner.nextInt();
		while(value < min || value > max) {
			System.out.println("You must enter between" + min + " to" + max);
			System.out.println(title);
			value = scanner.nextDouble();
			}
		return value;
	}
	public static double calmortgage(
			int Principal,
			float annualRate,
			byte Year ) {
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
		short numberOfPayment = (short)(Year * MONTHS_IN_YEAR);
		double mortgage = Principal * (monthlyRate *Math.pow(1+ monthlyRate, numberOfPayment))
				/ (Math.pow(1+ monthlyRate, numberOfPayment) -1 );
		return mortgage;
	}
}
