package projectdemo;

import java.text.NumberFormat;

public class CalculatePrint {

	private CalculateMortgage calculator;
	private final NumberFormat currency;
	
	public CalculatePrint(CalculateMortgage calculator) {
		this.calculator = calculator;
		currency = NumberFormat.getCurrencyInstance();
	}
	
	public void printPayment() {
		System.out.println();
		System.out.println("Payment Schedule: ");
		System.out.println("--------------------");
		
		for(double balance:calculator.getRemainingBalance())
			System.out.println(currency.format(balance));
	}
	
	public void printMortgage() {
		double mortgage = calculator.calMortgage();
		String mortgageFormatted = currency.format(mortgage);
		System.out.println();
		System.out.println("MORTGAGE");
		System.out.println("-----------");
		System.out.println("Monthly Payment: " + mortgageFormatted);
	}
}
