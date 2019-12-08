package DataStructures;
import java.util.*;
public class MinStack {
	// need 2 stacks
	// one hold value
	// one hold min number
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int item) {
		stack.push(item);
		if(minStack.isEmpty()) {minStack.push(item);}
		
		else if(item < minStack.peek())
			minStack.push(item);
	}
	
	public int pop() {
		if(stack.isEmpty())
			throw new IllegalArgumentException();
		int top = stack.pop();
		
		if(minStack.peek() == top)
			minStack.pop();
		
		return top;
	}
	public int min() {
		return minStack.peek();
	}

}
