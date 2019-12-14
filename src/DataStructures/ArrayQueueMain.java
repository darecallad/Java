package DataStructures;

public class ArrayQueueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		int Q = queue.peek();
		System.out.println(Q);
		System.out.println(queue);
		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
	}

}
