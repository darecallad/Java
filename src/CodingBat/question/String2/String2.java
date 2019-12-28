package CodingBat.question.String2;
// check last five questions
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
        for(int i =0; i < str.length()-2 ; i ++){
            if(str.substring(i,i+3).equals("cat"))
                catcount++;
            else if(str.substring(i,i+3).equals("dog"))
                dogcount++;
            else;
        }
        return catcount == dogcount;
    }
//    Return the number of times that the string "code" appears anywhere in the given string,
//    except we'll accept any letter for the 'd', so "cope" and "cooe" count.
    public int countCode(String str) {
        int count = 0;
        for(int i = 0; i < str.length()-3; i ++){
            if(str.substring(i,i+2).equals("co") && str.substring(i+3,i+4).equals("e"))
                count++;
        }
        return count;
    }
//    Given two strings, return true if either of the strings appears at the very end of the other string,
//    ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
//    Note: str.toLowerCase() returns the lowercase version of a string.
    public boolean endOther(String a, String b) {
        String as = a.toLowerCase();
        String bs = b.toLowerCase();
        int la = a.length();
        int lb = b.length();
        if(la > lb)
            return as.substring(la-lb).equals(bs);
        return bs.substring(lb-la).equals(as);
    }
//    Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded
//    by a period (.). So "xxyz" counts but "x.xyz" does not.
    public boolean xyzThere(String str) {
        boolean result = false;
        for(int i = 0 ; i < str.length() - 2; i ++){
            if(str.substring(i,i+3).equals("xyz"))
                if(i == 0 || str.charAt(i-1) != '.')
                    result = true;
        }
        return result;
    }
//    Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    public boolean bobThere(String str) {
        boolean result = false;
        for(int i = 0; i < str.length()-2 ; i ++){
            if(str.substring(i,i+1).equals("b") && str.substring(i+2,i+3).equals("b"))
                result = true;
        }
        return result;
    }
//    We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere
//    later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if
//    the given string is xy-balanced.
    public boolean xyBalance(String str) {
        int len = str.length() -1;
        char ch;
        for( int i = len ; i >= 0; i --){
            ch =str.charAt(i);
            if(ch == 'x')   return false;
            else if ( ch == 'y')    return true;
        }
        return true;
    }
//    Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second
//    char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
    public String mixString(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        String result = "";
        if(alen > blen){
            for(int i = 0; i < blen; i ++){
                result = result + a.charAt(i) + b.charAt(i);
            }
            result = result + a.substring(alen-(alen-blen));
        }
        else if(blen > alen){
            for(int i = 0; i < alen; i ++){
                result = result +a.charAt(i) + b.charAt(i);
            }
            result = result + b.substring(blen - (blen - alen));
        }
        else{
            for(int i = 0; i < alen; i ++){
                result = result + a.charAt(i) + b.charAt(i);
            }
        }
        return result;
    }

//    Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
//    You may assume that n is between 0 and the length of the string, inclusive.
    public String repeatEnd(String str, int n) {
        String sub = str.substring(str.length()-n);
        String result = "";
        for(int i = 0; i < n; i ++)
            result = result + sub;

        return  result;
    }
//    Given a string and an int n, return a string made of the first n characters of the string,
//    followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and
//    the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
    public String repeatFront(String str, int n) {
        StringBuilder builder = new StringBuilder((n*n + n)/2);
        for(int i = n; i >= 1; i--)
        {
            for(int k = 0; k < i; k++)
                builder.append(str.charAt(k));
        }
        return builder.toString();
    }
//    Given two strings, word and a separator sep, return a big string made of count occurrences of the word,
//    separated by the separator string.
    public String repeatSeparator(String word, String sep, int count) {
        if(count == 1)  return word;
        if(count == 0)  return  "";
        String result = "";
        String set = sep + word;
        for(int i = 0; i < count -1; i ++){
            result = result +set;
        }
        return word + result;
    }
//    Given a string, consider the prefix string made of the first N chars of the string. Does that prefix
//    string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..
//        str.length().
    public boolean prefixAgain(String str, int n) {
        String sub = str.substring(0,n);
        return str.substring(n).contains(sub);
    }
//    Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of
//    chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
    public boolean xyzMiddle(String str) {
        if(str.length() <3)    return false;
        int len = str.length();
        int mid = len/2;
        if(len%2 == 0){
            if(str.charAt(mid) == 'y')
                return str.charAt(mid-1) == 'x' && str.charAt(mid + 1) == 'z';
            else if(str.charAt(mid -1) == 'y')
                return str.charAt(mid-2)== 'x' && str.charAt(mid) == 'z';
        }
        else{
            if(str.charAt(mid) == 'y')
                return str.charAt(mid-1) == 'x' && str.charAt(mid + 1) == 'z';
        }
        return false;
    }
//    A sandwich is two pieces of bread with something in between. Return the string that is between the first and
//    last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.
    public String getSandwich(String str) {
        int First = str.indexOf("bread");
        int Last = str.lastIndexOf("bread");
        if(First != Last && First != -1 && Last != -1)
            return str.substring(First+5,Last);
        return "";
    }
//    Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star,
//    they are the same.
    public boolean sameStarChar(String str) {
        int len = str.length();
        for(int i = 1; i  < len -1 ; i ++){
            if(str.charAt(i) == '*'){
                if(str.charAt(i-1) != str.charAt(i+1))
                    return false;
            }
        }
        return true;
    }
//    Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca"
//            . Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group
//    of fewer than 3 chars at the end.
    public String oneTwo(String str) {
        String result = "";
        char ch;
        String sub;
        for(int i = 0; i < str.length()-2; i = i +3){
            ch = str.charAt(i);
            sub = str.substring(i+1,i+3);
            result = result +sub + ch;
        }
        return  result;
    }

//    Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'.
//    Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
    public String zipZap(String str) {
        char ch;
        StringBuilder builder = new StringBuilder(str.length());
        int i = 0;
        int lem = str.length()-2;
        while (i<str.length()){
            ch = str.charAt(i);
            if(ch == 'z' && i < lem && str.charAt(i+2)=='p'){
                builder.append("zp");
                i +=3;
            }
            else{
                builder.append(ch);
                i++;
            }
        }
        return builder.toString();
    }
//    Return a version of the given string, where for every star (*) in the string the star and the chars immediately
//    to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
    public String starOut(String str) {
        int len = str.length();
        int[] indexes = new int[len];
        char ch;
        StringBuilder stbuild = new StringBuilder(len);
        for(int i = 0; i < len; i++)
        {
            if(str.charAt(i) == '*')
            {
                indexes[i] = 1;
                if(i >= 1)
                    indexes[i-1] = 1;
                if(i < (len-1))
                    indexes[i+1] = 1;
            }
        }
        for(int i = 0; i < len; i++)
        {
            if(indexes[i] == 0)
                stbuild.append(str.charAt(i));
        }
        return stbuild.toString();
    }
//    Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
    public String plusOut(String str, String word) {
        int len = str.length();
        int wLen = word.length();
        int pos = str.indexOf(word);
        int i = 0;
        StringBuilder stbuild = new StringBuilder(len);
        while(pos != -1)
        {
            while(i < pos)
            {
                stbuild.append('+');
                i++;
            }
            stbuild.append(word);
            i = pos + wLen;
            pos = str.indexOf(word, i);
        }
        for(; i < len; i++)
            stbuild.append('+');
        return stbuild.toString();
    }
//    Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.
    public String wordEnds(String str, String word) {
        int len = str.length();
        int wLen = word.length();
        int pos = str.indexOf(word);
        int i = 0;
        StringBuilder stbuild = new StringBuilder(len);
        while(pos != -1)
        {
            i = pos + wLen;
            if(pos >= 1)
                stbuild.append(str.charAt(pos-1));
            if(i < len)
                stbuild.append(str.charAt(pos+wLen));
            pos = str.indexOf(word, i);
        }
        return stbuild.toString();
    }

    ///// check last 5 questions


}
