package DataStructures;

public class PriorityQMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQ queue = new PriorityQ(5);
		queue.enqueu(10);
		queue.enqueu(5);
		queue.enqueu(30);
		System.out.println(queue);
		int q =queue.dequeue();
		System.out.println(q);
		System.out.println(queue);
		queue.enqueu(3);
		System.out.println(queue);
		System.out.println(queue.peek());
	}

}
