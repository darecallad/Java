package DataStructures;
import java.util.*;
public class PriorityQ {
	private int[] items;
	private int count =0;
	
	public PriorityQ(int capacity) {
		items = new int[capacity];
	}
	
	public void enqueu(int item) {
		if(isFull())	throw new IllegalArgumentException();
		if(isEmpty())
			items[count] = item;
		int i;//shift item
		for(i=count -1; i >= 0; i --) {
			if(items[i] > item)
				items[i+1] = items[i];
			else
				break;
		}
		items[i+1] = item;
		count++;
	}
	public int dequeue() {
		if(isEmpty()) throw new IllegalArgumentException();
		int top = items[count];
		items[count] = 0;
		count--;
		return top;
	}
	public int peek() {
		if(isEmpty()) throw new IllegalArgumentException();
		int pop = items[count-1];
		return pop;
	}
	@Override
	public String toString() {
		return Arrays.toString(items);
	}
	public boolean isEmpty(){
		return count == 0;
		}
	public boolean isFull() {
		return count == items.length;
	}

}
