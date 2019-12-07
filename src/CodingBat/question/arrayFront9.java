package CodingBat.question;


//Given an array of ints, return true if one of the first 4 elements in the array is a 9. 
//		The array length may be less than 4.
//
//
//arrayFront9([1, 2, 9, 3, 4]) → true
//arrayFront9([1, 2, 3, 4, 9]) → false
//arrayFront9([1, 2, 3, 4, 5]) → false
public class arrayFront9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = new int[] {1,2,9,3,4};
		System.out.println(arrayFront9(array1));
	}
	public static boolean arrayFront9(int[] nums) {
		  
		int checkpoint = 4;
		boolean result = false;  
		if(nums.length < 4)
			  checkpoint = nums.length;
		  
		for(int i = 0; i < checkpoint; i ++) 
			  if(nums[i] == 9) 
				  result = true;
			  
		return result;
		  
	}


}
