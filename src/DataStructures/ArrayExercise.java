package DataStructures;

public class ArrayExercise {
    public static void main(String[] args){
        Array1 numbers = new Array1(3);
//        numbers.print();
        numbers.insert(10);
//        numbers.print();
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(10);

//        System.out.println(numbers.max());
//        numbers.print();
//        numbers.reverse();
//        numbers.insertAt(20,1);
//        numbers.print();
        numbers.intersect();
//        numbers.removeAt(1);
//        numbers.print();
//        System.out.println(numbers.indexOf(40));
//        numbers.removeAt(3);
//        System.out.println(numbers.indexOf(10));
//        System.out.println(Arrays.toString(numbers));
    }
}
