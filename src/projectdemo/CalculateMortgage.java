package projectdemo;

import java.util.Scanner;

public class CalculateMortgage {


	private final int MONTHS_IN_YEAR = 12;
	private final int PERCENT = 100;
	private int principal;
	private float annualRate;
	private byte years;
	private static Scanner scanner = new Scanner(System.in);
	
	public CalculateMortgage(int principal, float annualRate, byte years) {
		this.principal = principal;
		this.annualRate =annualRate;
		this.years = years;
		
	}
	
	private float getMonthlyRate() {
		return annualRate / PERCENT / MONTHS_IN_YEAR;
	}
	
	private int getNumberOfPayment() {
		return years * MONTHS_IN_YEAR;
	}
	
	public static double readNumber(
			String title,
			int max,
			int min) {
		System.out.println(title + " (Enter between "+ min +" and "+ max + ")");
		double value = scanner.nextDouble();
		while(value < min || value > max) {
			System.out.println("You must enter between" + min + " to" + max);
			System.out.println(title+": ");
			value = scanner.nextDouble();
			}
		return value;
	}

	public double calMortgage(
			) {
		float monthlyRate = getMonthlyRate();
		float numberOfPayment = getNumberOfPayment();		
		double mortgage = principal * (monthlyRate *Math.pow(1+ monthlyRate, numberOfPayment))
				/(Math.pow(1+ monthlyRate, numberOfPayment) -1);
		return mortgage;
	}

	public double[] getRemainingBalance() {
		double[] balance = new double[getNumberOfPayment()];
		for(short month = 1; month <= balance.length; month++)
			balance[month-1] = calBalance(month);
		return balance;
	}

	public double calBalance(short month) {
		float monthlyRate = getMonthlyRate();
		float numberOfPayment = getNumberOfPayment();
		
		double balance = principal * (Math.pow(1+ monthlyRate, numberOfPayment) 
				- (Math.pow (1+monthlyRate, month))) / (Math.pow(1+monthlyRate, numberOfPayment) -1);
		return balance;
	}
}
