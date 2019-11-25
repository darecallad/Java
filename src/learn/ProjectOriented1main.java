package learn;
// easy to maintain
public class ProjectOriented1main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProjectOriented1Employee employee = new ProjectOriented1Employee();
		//employee.baseSalary = -1;
		employee.setBaseSalary(50_000);
		//employee.hourlyRate = 20;
		employee.setHourlyRate(20);
		int wage = employee.calculateWage(10);
		System.out.println(wage);
	}
	


}
