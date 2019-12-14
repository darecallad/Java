package DataStructures;
import java.util.*;

public class ArrayQueue {
	private int F = 0;
	private int R = 0;
	private int count = 0;
	private int[] items;
	

	
	public ArrayQueue(int capacity) {
		items = new int[capacity];
	}

	public boolean isEmpty() {
		return count == 0;
	}
	public boolean isFull() {
		return items.length == count;
	}
	public void enqueue(int item) {
		// TODO Auto-generated method stub
		if(isFull())
			throw new IllegalArgumentException();
		items[R] = item;
		R =(R+1) % items.length; // circular Arrays
		count++;
	}
	public int dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException();
		int item = items[F];
		items[F] = 0;
		F = (F+1) % items.length;
		count--;
		return item;
	}
	public int peek() {
		return items[F];
	}
	@Override
	public String toString() {
		return Arrays.toString(items);
	}

}
