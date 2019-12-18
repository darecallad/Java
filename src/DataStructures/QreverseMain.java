package DataStructures;
import java.util.*;
public class QreverseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		System.out.println(queue);

	}
	public void reverse(Queue<Integer> queue, int k) {
		if(k< 0 || k > queue.size())
			throw new IllegalStateException();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<k ; i ++) {
			stack.push(queue.remove());
		}
		while(!stack.isEmpty())
			queue.add(stack.pop());
		
		for(int i = 0; i < queue.size()- k; i ++)
			queue.add(queue.remove());
	}

}
