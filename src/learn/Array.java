package learn;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		System.out.println("...");
		
		int[] number = new int[5];
		number[0] = 1;
		number[1] = 0;
		System.out.println(number); //print address
		System.out.println(Arrays.toString(number));
		
		//
		
		int[] number1 =	{1,4,5,2,5};
		System.out.println(number1.length);
		Arrays.sort(number1);
		System.out.println(Arrays.toString(number1));
		
		
		// 2D arrays
		
		int[][] numbers = new int[2][3];
		numbers[0][0] = 1;
		
		System.out.println(Arrays.deepToString(numbers));
					
	
		int[][] number2 = {{1,2,3},{4,5,6}};
		System.out.println(Arrays.deepToString(number2));
	}
					}
