package CodingBat.question.String3;

public class String3 {
//    Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
    public int countYZ(String str) {
        int count = 0;
        str = str.toLowerCase();
        char ch;
        ch = str.charAt(0);
        for(int i = 1; i  <= str.length()-1; i++ ){
            if(ch == 'y' || ch == 'z'){
                ch = str.charAt(i);
                if(!Character.isLetter(ch))
                    count ++;
            }
            else
                ch = str.charAt(i);
        }
        if(ch == 'y' || ch == 'z')
            count++;
        return  count;
    }
//  1  Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
    public String withoutString(String base, String remove) {
        char[] charr = new char[base.length()];
        int count = 0;
        int i = 0;

        while( i <= base.length() - remove.length()){
            if(base.substring(i,i+remove.length()).toLowerCase().equals(remove.toLowerCase()))
                i = i + remove.length();
            else{
                charr[count] = base.charAt(i);
                count++;
                i++;
            }
        }
        while ( i < base.length()){
            charr[count] = base.charAt(i);
            count ++ ;
            i ++;
        }
        return new String(charr,0,count);
    }
//2
//    Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive).
    public boolean equalIsNot(String str) {
        int len = str.length();
        int is = 0;
        int not = 0;

        for(int i =0; i < len; i ++){
            if(i < len -2){
                String temp  = str.substring(i,i+3);
                if(temp.equals("not"))
                    not++;
            }
            if(i < len -1){
                String temp1 = str.substring(i,i+2);
                if(temp1.equals("is"))
                    is++;
            }
        }
        return is == not;
    }
//    We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy.
//    3
    public boolean gHappy(String str) {
        str = str.toLowerCase();
        int len = str.length();
        if (len == 0) return true;
        if(len == 1 && str.charAt(0) == 'g')    return false;
        if(len >= 2 &&
                (str.charAt(0) == 'g' && str.charAt(1) != 'g') ||
                (str.charAt(len -1) == 'g' && str.charAt( len -2) != 'g'))
            return false;
        for( int i = 1; i <= len -2 ; i ++){
            if(str.charAt(i) == 'g' && str.charAt(i-1) != 'g' && str.charAt(i+1) != 'g')
                return false;
        }
        return true;
    }
//    4
//    We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap.
    public int countTriple(String str) {
        int count = 0;
        for( int i =0; i <= str.length()-3; i ++){
            if(str.charAt(i) == str.charAt(i+1) &&
                    str.charAt(i+1) == str.charAt(i+2))
                count++;
        }
        return count;
    }
    //  5
    //  Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

    public int sumDigits(String str) {
        int len = str.length();
        int sum = 0;
        for( int i = 0; i < len ; i ++){
            if(Character.isDigit(str.charAt(i))){
                String temp = str.substring(i,i+1);
                sum += Integer.parseInt(temp);
            }
        }
        return sum;
    }
    //  6
    // Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. For example, sameEnds("abXab") is "ab".
    public String sameEnds(String string) {
        int len = string.length();
        String fin = "";
        String temp = "";

        for( int i =0; i < len ; i ++){
            temp += string.charAt(i);
            int templen = temp.length();
            if(i < len/2 && temp.equals(string.substring(len - templen,len)))
                fin = temp;
        }
        return fin;
    }
    // 7
    // Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
    public String mirrorEnds(String string) {
        int len = string.length();
        String fin = "";
        String temp1 = "";
        String temp2 = "";

        for( int i =0; i < len ; i ++){
            temp1 += string.substring(i,i+1);
            temp2 = "";
            for( int j = temp1.length()-1; j >=0; j --){
                temp2 += temp1.substring(j,j+1);
                if(temp2.equals(string.substring(len-i-1, len)))
                    fin = temp1;
            }
        }
        return fin;
    }
    //  8
    // Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
    public int maxBlock(String str) {
        int len = str.length();
        if( len == 0) return 0;
        int count = 0;
        int tempcount = 1;

        for(int i =0; i < len; i ++){
            if(i < len -1 && str.charAt(i) == str.charAt(i+1))
                tempcount ++;
            else
                tempcount = 1;

            if(tempcount > count)
                count = tempcount;
        }
        return count;
    }
    //  9
    //Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
    public int sumNumbers(String str) {
        int len = str.length();
        int sum = 0;
        String temp = "";

        for( int i = 0; i < len ; i ++){
            if(Character.isDigit(str.charAt(i))){
                if( i < len -1 && Character.isDigit(str.charAt(i+1))){
                    temp += str.charAt(i);
                }
                else{
                    temp = temp + str.charAt(i);
                    sum = sum + Integer.parseInt(temp);
                    temp = "";
                }
            }
        }
        return sum;
    }
    // 10
    // Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count. (Note: Character.isLetter(char) tests if a char is a letter.)
    public String notReplace(String str) {
        String result = "";
        int len = str.length();

        for( int i =0; i < len ; i ++){
            if(i -1 >= 0  && Character.isLetter(str.charAt(i-1)) ||
            i + 2 < len && Character.isLetter(str.charAt(i+2)))
                result = result +str.charAt(i);
            else if(i+1 < len && str.substring(i, i+2).equals("is")){
                result = result + "is not";
                i++;
            }
            else result = result + str.charAt(i);
        }
        return result;
    }
}
