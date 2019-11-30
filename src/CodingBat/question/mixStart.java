package CodingBat.question;
//Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.
//
//
//        mixStart("mix snacks") → true
//        mixStart("pix snacks") → true
//        mixStart("piz snacks") → false
public class mixStart {
    public static void main(String[] args){
        System.out.println(mixStart("mix snacks"));
        System.out.println(mixStart("pix snacks"));
        System.out.println(mixStart("piz snacks"));
    }

    public static boolean mixStart(String str) {
        if(str.length()<3)
            return false;
        return (str.substring(1,3).equals("ix"));

    }
}
