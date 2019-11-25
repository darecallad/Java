package projectdemo;

public class EmployeeCal {

	private final int MONTH_IN_YEAR = 12;
	double yearlySalary;
	int workingHour;
	public EmployeeCal(double yearlySalary, int workingHour) {
		// TODO Auto-generated constructor stub
		this.workingHour = workingHour;
		this.yearlySalary = yearlySalary;
	}
	
	private double getMonthlyPayment() {
		return yearlySalary / MONTH_IN_YEAR;
	}
	
	public double hourlyPay() {
		double hourlypayment = getMonthlyPayment() / workingHour;
		return hourlypayment;
	}

}
