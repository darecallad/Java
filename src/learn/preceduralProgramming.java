package learn;
// hard to maintain
// too many functions cannot be reuse
public class preceduralProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int baseSalary = 50_000;
		int extraHours = 10;
		int hourlyRate = 20;
		
		int wage = calculateWage(baseSalary,extraHours,hourlyRate);
		System.out.println(wage);
	}
	
	public static int calculateWage(
			int baseSalary,
			int extraHours,
			int hourlyRate) {
		return baseSalary + (extraHours * hourlyRate);
	}

}
