package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList2 {
	private Node first;
	private Node last;
	private int size;
	
	public class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private boolean isEmpty() {
		return first == null;
	}
	private Node getPrevious(Node node) {
		Node current = first;
		while(current != null) {
			if(current.next == last)
				return current;
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
			last = node;
		}
		size ++;
	}
	public void addFirst(int item) {
		Node node = new Node(item);
		if(isEmpty())
			first = last = node;
		else {
			node.next = first;
			first = node;
		}
		size++;
	}
	public void removeFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(first == last) {
			first = last = null;
			size = 0;
			return;
		}
		else {
			Node second = first.next;
			first.next = null;
			first = second;
			size --;
		}
	}
	public void removeLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(first == last) {
			first = last = null;
			size = 0;
			return;
		}
		else {
			Node previous = getPrevious(last);
			last = previous;
			last.next = null;
			size --;
		}
	}
	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while(current.next != null) {
			if(current.value == item)	return index;
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
		int index = 0;
		int[] array = new int[size];
		Node current = first;
		while(current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}

}
