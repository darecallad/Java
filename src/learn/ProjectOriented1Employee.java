package learn;

public class ProjectOriented1Employee {

	private int baseSalary;
//	public int extraHours;
	// this one can be changed everytime 
	private int hourlyRate;
	//private =  cannot access outside the class

	public int calculateWage(int extraHours) {
		return baseSalary + (extraHours * hourlyRate);
	}

	public void setBaseSalary(int baseSalary) {
		if (baseSalary <= 0)
			throw new IllegalArgumentException("Base salary cannot be 0 or negative.");
		this.baseSalary = baseSalary;
	}
	
	public int getBaseSalary() {
		return baseSalary;
	}
	
	public void setHourlyRate(int hourlyRate) {
		if(hourlyRate <= 0)
			throw new IllegalArgumentException("Cannot be 0 or negative.");
		this.hourlyRate = hourlyRate;
	}
	public int getHourlyRate() {
		return hourlyRate;
	}
}
