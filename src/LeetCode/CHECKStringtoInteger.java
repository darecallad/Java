package LeetCode;

import DataStructures.ChatFinder;

public class CHECKStringtoInteger {
    public int myAtoi(String str) {

        int number = 0;
        int sign = 1;

        if(!str.isEmpty()){
            int i = 0;
            while(i < str.length() -1 && str.charAt(i) == ' ') // if i isnt the last one and i isnt a space
                i++;    // increase i

            char msb = str.charAt(i);
            if(msb == '-' || msb == '+'){ // if the char is - or +
                i++;
                if(i < str.length() && Character.isDigit(str.charAt(i))){ // if the cahracter is Digit
                    sign = ( 45  == msb ) ? -1 : 1; // and 45 == -
                    number = sign * (str.charAt(i) - 48);
                    i ++;
                }
            }

            while(i < str.length() && Character.isDigit(str.charAt(i))){
                int add = (str.charAt(i) - 48);
                if(number > Integer.MAX_VALUE/10 || (number ==Integer.MAX_VALUE/10 && add>7))
                    return Integer.MAX_VALUE;
                if(number < Integer.MIN_VALUE/10 || (number ==Integer.MIN_VALUE/10 && add>8))
                    return Integer.MIN_VALUE;
                number = number * 10  + (sign * add);
                i++;
            }
        }
        return number;
    }

}
