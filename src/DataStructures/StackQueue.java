package DataStructures;
import java.util.*;
public class StackQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public StackQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void enqueue(int item) { //O(1)
		stack1.push(item);
	}
	public int dequeue() {//O(n)
		if(stack1.isEmpty() && stack2.isEmpty())
			throw new IllegalStateException();
		
		moveStack1toStack2();
		
		return stack2.pop();
	}
	
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public int peek() {if(stack1.isEmpty() && stack2.isEmpty())
		throw new IllegalStateException();
	
	moveStack1toStack2();
	
	return stack2.peek();
		
	}

	private void moveStack1toStack2() {
		if(stack2.isEmpty())
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
	}

}
