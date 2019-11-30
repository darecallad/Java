package CodingBat.question;


//Given a string, return true if the string starts with "hi" and false otherwise.
//
//
//        startHi("hi there") → true
//        startHi("hi") → true
//        startHi("hello hi") → false
public class startHi {
    public static void main(String[] args){
        System.out.println(startHi("hi there"));
        System.out.println(startHi("hi"));
        System.out.println(startHi("hello hi"));
    }
    public static boolean startHi(String str) {
        if(str.length()<2)
            return false;
        return (str.substring(0,2).equals("hi"));

    }

}
