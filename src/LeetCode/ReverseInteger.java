package LeetCode;
//Given a 32-bit signed integer, reverse digits of an integer.
//
//Example 1:
//
//Input: 123
//Output: 321
//Example 2:
//
//Input: -123
//Output: -321
//Example 3:
//
//Input: 120
//Output: 21

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0; // set result = 0;
        //we divide x by 10 each time
        //x will be 0 in the end

        while( x != 0){
            int modleft = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && modleft > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && modleft < -8)) return 0;
            result = result * 10 + modleft;
            // devide 10 first so we times 10 back

        }
        return  result;
    }
}
