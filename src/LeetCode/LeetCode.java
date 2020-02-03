package LeetCode;

public class LeetCode {
    // Two Sum  #1
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //Example:
    //
    //Given nums = [2, 7, 11, 15], target = 9,
    //
    //Because nums[0] + nums[1] = 2 + 7 = 9,
    //return [0, 1].
        public int[] twoSum(int[] nums, int target) {
            for(int i =0; i < nums.length; i ++){
                for(int j = i+1; j<nums.length; j ++){
                    if(nums[i] + nums[j] == target)
                        return new int[]{i,j};
                }
            }
            throw new IllegalArgumentException("no result");
        }
    // 2. Reverse Integer
    // Given a 32-bit signed integer, reverse digits of an integer.
        public int reverse(int x) {
            int result = 0;
            while (x != 0){
                int remind = x % 10;
                x = x /10;
                if( result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE && remind > 7 )
                    return 0;
                if( result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE && remind < -8)
                    return 0;
                result = result * 10 + remind;
            }
            return result;
        }
    // 3. Palindrome Number
    // Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
        public boolean isPalindrome(int x) {
            boolean result = false;
            int revernumber = 0;
            if( x < 0 || ( x % 10 == 0 && x != 0))
                return false;
            while ( x > revernumber){
                revernumber = revernumber * 10 + x % 10;
                x /= 10;
            }
            if(x == revernumber || x == revernumber/10)
                result = true;
            return result;
        }
    // 4. Roman to Integer
    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    // Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
        public int romanToInt(String s) {

        }
}
