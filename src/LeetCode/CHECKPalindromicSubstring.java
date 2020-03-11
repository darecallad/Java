package LeetCode;
//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//Example 1:
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//
//Input: "cbbd"
//Output: "bb"

public class CHECKPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end =0;
        if(len < 1 || s == null)    return  ""; // special condition

        for(int i = 0 ; i < len; i ++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int maxlen = Math.max(len1,len2);

            if(maxlen > end - start){ // if max len greater than string we select
                start = i - (maxlen - 1) /2;    // then we move start position to
                end = i + maxlen /2 ;
            }
        }
        return s.substring(start,end + 1);
    }
    private int expandAroundCenter(String s, int left, int right){
        int L = left;
        int R = right;

        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L -1;
    }
}
