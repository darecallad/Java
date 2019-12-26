package CodingBat.question.String2;

public class String2 {
//    Given a string, return a string where for every char in the original, there are two chars.
    public String doubleChar(String str) {
        String result = "";
        for(int i = 0;  i < str.length(); i ++){
            result = result + str.charAt(i) + str.charAt(i);
        }
        return result;
    }

//    Return the number of times that the string "hi" appears anywhere in the given string.
    public int countHi(String str) {
        int count = 0;
        for ( int i = 0; i < str.length()-1 ; i ++){
            if(str.substring(i,i+2).equals("hi"))
                count++;
        }
        return count;
    }
//    Return true if the string "cat" and "dog" appear the same number of times in the given string.
    public boolean catDog(String str) {
        int catcount = 0;
        int dogcount = 0;
        if(str.length() < 6)    return false;
        for(int i =0; i < str.length()-2 ; i ++){
            if(str.substring(i,i+4).equals("cat"))
                catcount++;
            if(str.substring(i,i+4).equals("dog"))
                dogcount++;
        }
        return catcount == dogcount;
    }
}
