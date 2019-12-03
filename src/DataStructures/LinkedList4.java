package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList4 {
	private Node first;
	private Node last;
	private int size;
	
	public class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}// ended Node class
	
	private boolean isEmpty() {
		return first == null;
	}
	private Node getPrevious(Node node) {
		Node current = first;
		while(current != null) {
			if(current.next == last) return current;
			current = current.next;
		}
		return null;
	}
	public void addLast(int item) {
		Node node = new Node(item);
		if(isEmpty())
			first = last = node;
		else {
			last.next = node;
			last = last.next;
		}
		size++;
	}
	public void addFirst(int item) {
		Node node = new Node(item);
		if(isEmpty())
			first = last = node;
		else {
			node.next = first;
			first = node;
		}
		size ++;
	}
	public void removeFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(first == last) {
			first = last = null;
			size = 0;
		}
		else {
			Node second = first.next;
			first.next = null;
			first = second;
			size--;
		}
	}
	public void removeLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(first == last) {
			first = last = null;
			size = 0;
		}
		else {
			Node previous = getPrevious(last);
			last = previous;
			last.next = null;
			size--;
		}
	}
	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while(current.next != null) {
			if(current.value == item) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}
	public int size() {
		return size;
	}
	public int[] toArray() {
		int index =0;
		int[] array = new int[size];
		Node current = first;
		while(current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}
	public int[] reverse1() {
		int index = 0;
		int[] array = new int[size];
		int[] array1 = new int[size];
		Node current = first;
		while(current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		for(int i = size-1, j = 0; i >=0 && j<array1.length; i--, j++) 
				array1[j] = array[i];
		return array1;
	}
	public void reverse() {
		if(isEmpty()) return;
		Node previous = first;
		Node current = first.next;
		last = first;
		last.next = null;
		while(current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		first = previous;
	}
	public int getKthFromTheEnd(int k) {
		Node a = first;
		Node b = first;
		for(int i =0; i< k-1 ; i++) {
			b= b.next;
		}
		while(b != last) {
			a = a.next;
			b = b.next;
		}
		return a.value;
	}
	public void printMiddle() {
		if(isEmpty())
			throw new NoSuchElementException();
		Node a = first;
		Node b = first;
		while(a != last && b!= last) {
			b = b.next.next;
			a = a.next;
		}
		if(b == last)
			System.out.println(a.value);
		else
			System.out.println(a.value + " " + a.next.value);
		
	}

}
