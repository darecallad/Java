package DataStructures;

public class ArrayExercise {
    public static void main(String[] args){
        Array1 numbers = new Array1(3);
        numbers.print();
        numbers.insert(10);
//        numbers.print();
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
//        numbers.print();
        numbers.removeAt(1);
        numbers.print();
        System.out.println(numbers.indexOf(40));
//        numbers.removeAt(3);
//        System.out.println(numbers.indexOf(10));
//        System.out.println(Arrays.toString(numbers));
    }
}
