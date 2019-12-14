package DataStructures;
import java.util.*;
public class Queues {
	//simliar to Stack
	// first in first out (FIFO)
	// Stack is First in Last out
	// printer , operating system, Web servers, Live support system
	// enqueue, dequeue, peek, isEmpty, isFull O(1)
	
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		reverse(queue);
		System.out.println(queue);
	}
	public static void reverse(Queue<Integer> queue) {		
		Stack<Integer> stack = new Stack<Integer>();
		while(!queue.isEmpty())
			stack.push(queue.remove());
		while(!stack.isEmpty())
			queue.add(stack.pop());
	}


}
