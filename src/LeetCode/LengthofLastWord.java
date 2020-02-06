package LeetCode;

public class LengthofLastWord {
    //Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
    //
    //If the last word does not exist, return 0.
    //
    //Note: A word is defined as a maximal substring consisting of non-space characters only.
    //
    //Example:
    //
    //Input: "Hello World"
    //Output: 5
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int len = 0; // last word length
        for( int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == ' ')
                len = 0;
            else
                len++;
        }
        return len;
    }
}
