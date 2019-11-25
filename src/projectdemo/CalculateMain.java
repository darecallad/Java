package projectdemo;

public class CalculateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int principal =(int)CalculateMortgage.readNumber("Principal: ", 10_000, 1_000);
		float annualRate = (float)CalculateMortgage.readNumber("AnnualRate: ",5,0);
		byte years = (byte)CalculateMortgage.readNumber("Years: ", 5, 0);
		CalculateMortgage mortgage = new CalculateMortgage(principal,annualRate,years);
		CalculatePrint report = new CalculatePrint(mortgage);
		report.printMortgage();
		report.printPayment();
	}

}

