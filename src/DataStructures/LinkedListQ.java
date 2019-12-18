package DataStructures;
import java.util.*;
public class LinkedListQ {
	private class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}// end ENtry class
	private Node head;
	private Node tail;
	private int count;
	
	public void enqueu(int item) {
		Node node = new Node(item);
		
		if(isEmpty())
			head = tail = node;
		else {
			tail.next = node;
			tail = node;
		}
		count++;
	}
	public int deququq() {
		if(isEmpty())
			throw new IllegalArgumentException();
		int value;
		if(head == tail) {
			value = head.value;
			head = tail = null;
		}
		else {
			value = head.value;
			Node second = head.next;
			head.next = null;
			head = second;
		}
		count --;
		return value;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return head.value;
	}
	public int size() {
		return count;
	}
	public String toString() {
		ArrayList<Integer> list = new ArrayList<>();
		
		Node current = head;
		while(current != null) {
			list.add(current.value);
			current = current.next;
		}
		return list.toString();
	}


}
