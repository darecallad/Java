package DataStructures;

import java.util.Arrays;

public class Stack1 {
	private int count = 0;
	private int[] array = new int[5];

	
	public void push(int number) {
		if(count == array.length)
			throw new StackOverflowError();
		
		array[count++] = number;
	}
	
	public int pop() {
		if(count == 0)
			throw new IllegalStateException();
		
		return array[--count];
	}
	public int peek() {
		if(count == 0)
			throw new IllegalStateException();
		
		return array[count-1];
	}
	public boolean isEmpty() {
		return count == 0;
	}
	@Override
	public String toString() {
		int[] current = Arrays.copyOfRange(array, 0, count);
		return Arrays.toString(current);
		
	}

}
