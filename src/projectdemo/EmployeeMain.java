package projectdemo;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double yearlySalary = EmployeeConsole.readValue("YearlySalary", 0 , 10_0000);
		int workingHour = (int)(EmployeeConsole.readValue("workinghours", 0, 60));
		EmployeeCal employee = new EmployeeCal(yearlySalary,workingHour);
		EmployeePrint report = new EmployeePrint(employee);
		report.printResult();
	}

}
