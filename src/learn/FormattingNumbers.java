package learn;

import java.text.NumberFormat;

public class FormattingNumbers {

	public static void main(String[] args) {
		//391204 ---> $391,204
		// 0.1 ---> 10%
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String result = currency.format(123456.657);
		System.out.println(result);
		
		NumberFormat precent = NumberFormat.getPercentInstance();
		//NumberFormat res = NumberFormat.getPercentInstance().format(0.1);
		String res = precent.format(0.1);
		System.out.println(res);
		
	}
}
