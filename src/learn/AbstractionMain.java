package learn;

public class AbstractionMain {
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	AbstractionEmployee employee = new AbstractionEmployee(50_000,20);
	//employee.baseSalary = -1;
	//employee.setBaseSalary(50_000);
	//employee.hourlyRate = 20;
	//employee.setHourlyRate(20);
	
	int wage = employee.calculateWage(10);
	System.out.println(AbstractionEmployee.numberOfEmployee);
	AbstractionEmployee.printNumberOfEmployee();
	System.out.println(wage);
	
	
	Coupling browser = new Coupling();
	browser.natigate("123");
	}
}
