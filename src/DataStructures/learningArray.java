package DataStructures;

import java.util.Arrays;

public class learningArray {
    // array are static and cannot change later on
    // look up O(1) , insertO(n), Delete O(1), worst Delete O(n)

    public static void main(String[] args){
        int[] numbers = new int[3];
        System.out.println(numbers); // memory
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        // int[] numbers = {10,20,30};
        // numbers.length print the size of array
        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers.length);
    }
}
