package interfface;

public class TaxReport {

	private ITaxCalculator calculator;
	
//	public TaxReport(ITaxCalculator calculator) {
//		this.calculator = calculator;
//	}
	
	public void show(ITaxCalculator calculator) {
		double tax = calculator.calculateTax();
		System.out.println(tax);
	}
//	
//	public void setCalculator(ITaxCalculator calculator) {
//		this.calculator = calculator;
//	}
}
