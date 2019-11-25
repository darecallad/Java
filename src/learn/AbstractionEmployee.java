package learn;

public class AbstractionEmployee {
	private int baseSalary;
//	public int extraHours;
	// this one can be changed everytime 
	private int hourlyRate;
	//private =  cannot access outside the class

	public static int numberOfEmployee;
	public AbstractionEmployee(int baseSalary, int hourlyRate) {
		//this.baseSalary = baseSalary;
		setBaseSalary(baseSalary);
		setHourlyRate(hourlyRate);
		numberOfEmployee++;
	}
	
	public static void printNumberOfEmployee() {
		System.out.println(numberOfEmployee);
	}
	//overload constructor
	public AbstractionEmployee(int baseSalary ) {
		//this.baseSalary = baseSalary;
		setBaseSalary(baseSalary);
		setHourlyRate(0);
		// this(baseSalary,0); this one better
	}
	public int calculateWage(int extraHours) {
		return baseSalary + (extraHours * hourlyRate);
	}
	//overloading
	public int calculateWage() {
		return baseSalary;
		// return calculateWage(0);
	}


	private void setBaseSalary(int baseSalary) {
		if (baseSalary <= 0)
			throw new IllegalArgumentException("Base salary cannot be 0 or negative.");
		this.baseSalary = baseSalary;
	}
	
	private int getBaseSalary() {
		return baseSalary;
	}
	
	private void setHourlyRate(int hourlyRate) {
		if(hourlyRate < 0)
			throw new IllegalArgumentException("Cannot be 0 or negative.");
		this.hourlyRate = hourlyRate;
	}
	private int getHourlyRate() {
		return hourlyRate;
	}
	
	
}
