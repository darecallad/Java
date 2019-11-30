package CodingBat.question;
//Given an int n, return the absolute difference between n and 21
// , except return double the absolute difference if n is over 21.
//        diff21(19) → 2
//        diff21(10) → 11
//        diff21(21) → 0


public class diff21 {

    public static void main(String[] args){
        System.out.println(diff21(20));
        System.out.println(diff21(22));
        System.out.println(diff21(18));
    }
    public static int diff21(int n){
        if(21-n >= 0)
            return 21-n;
        return (n-21)*2;
    }
}
