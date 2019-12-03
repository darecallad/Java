package DataStructures;

import java.util.ArrayList;

public class DynamicArray {
    //Vector: 100% - synchronized
    //ArrayList: 50%
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); //int type
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);
        list.contains(0);
        list.toArray();
    }

}
