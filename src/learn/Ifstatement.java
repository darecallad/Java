package learn;

public class Ifstatement {

	public static void main (String[] args) {
		
		int temp = 28;
		if(temp>30) {
			System.out.println("HOT_DAY");
		}else if(temp>20 &&temp <=30) {
			System.out.println("Beautiful day");
		}else {
			System.out.println("Cold Day");
		}
		
		///////
		
		int income = 120_000;
		boolean hasHighIncome = income >100_000;
		
		
		String className;
		if(income > 100_000) {
			className = "First";
		}
		else {
			className = "Economy";
		}
		// String className = income >100_000 ? "First" : "Economy";
	}
}
