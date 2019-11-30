package CodingBat.question;

//Given three int values, a b c, return the largest.
//
//
//        intMax(1, 2, 3) → 3
//        intMax(1, 3, 2) → 3
//        intMax(3, 2, 1) → 3
public class intMax {
    public static void main(String[] args){
        System.out.println(intMax(1, 2, 3));
        System.out.println(intMax(1, 3, 2));
        System.out.println(intMax(3, 2, 1));
    }
    public static int intMax(int a, int b, int c) {
        int max;
        if(a>b)
            max = a;
        else max = b;
        if(c>max)
            return c;
        return max;
    }
}
