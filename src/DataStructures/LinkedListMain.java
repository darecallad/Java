package DataStructures;

import java.util.Arrays;

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// add first
		// add Last
		// remove first
		// remove last
		// indexOf
		// size
		// toArray
		// contains
		LinkedList4 list = new LinkedList4();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addFirst(20);
		System.out.println(list.indexOf(20));
		System.out.println(list.size());
		list.removeFirst();
		System.out.println(list.size());
		int[] array =list.toArray();
		System.out.println(Arrays.toString(array));
	}

}
