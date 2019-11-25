package smallprojects;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		final String DIVFIVE = "Fizz";
		final String DIVTHREE = "Buzz";
		final String DIVFIFTEN = "FizzBuzz";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input a number: ");
		int input = scanner.nextInt();
		
		if(input%15==0) {
			System.out.println(DIVFIFTEN);
		}else if(input%5==0) {
			System.out.println(DIVFIVE);
		}else if (input %3 ==0) {
			System.out.println(DIVTHREE);
		}else {
			System.out.println(input);
		}
		
	}
}
