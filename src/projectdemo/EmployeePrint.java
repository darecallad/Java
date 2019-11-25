package projectdemo;

import java.text.NumberFormat;

public class EmployeePrint {

	private EmployeeCal report;
	private NumberFormat currency;
	
	public EmployeePrint(EmployeeCal employee) {
		// TODO Auto-generated constructor stub
		this.report = employee;
		currency = NumberFormat.getCurrencyInstance();
	}

	public void printResult() {
		// TODO Auto-generated method stub
		double Hourlypay = report.hourlyPay();
		String formatted = currency.format(Hourlypay);
		System.out.println("Hourly Pay: " + formatted);
		
		
	}
}
