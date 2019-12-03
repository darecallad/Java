package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList {

	private Node first;
	private Node last;
	
	private class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private int size;
	
	private boolean isEmpty() {
		return first == null;
	}
	public void addLast(int item) {
		Node node = new Node(item);
		if(isEmpty())
			first= last = node;
			
		else {
			last.next = node;
			last = node;
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
		size++;
	}
	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while(current != null) {
			if(current.value==item) return index;
			current = current.next;
			index++;
		}
		return -1;
	}
	public boolean contains(int item) {
		// return indexOf(item) != -1;
		int index = 0;
		Node current = first;
		while(current != null) {
			if(current.value == item) return true;
			current.next = current;
			index++;
		}
		return false;
	}
	public void removeFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(first == last) {
			first = last = null;
			size = 0;
			return;
		}
		Node second = first.next;
		first.next = null;
		first = second;
		size --;
	}
	public void removeLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		if(first == last) {
			first = last = null;
			size  = 0;
			return;
		}
		Node previous = getPrevious(last);
		last = previous;
		last.next = null;
		size--;
	}
	
	private Node getPrevious(Node node) {
		Node current = first;
		while(current != null) {
			if(current.next ==last) return current;
			current = current.next;
		}
		return null;
	}
	public int size() {
		return size;
	}
	
	public int[] toArray() {
		int[] array = new int[size];
		Node current = first;
		int index = 0;
		while(current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}
	public void reverse() {
		Node previous = first;
		Node current = first.next;
		while(current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		last = first;
		last.next = null;
		first = previous;
	}
	public int getKthFromTheEnd(int k) {
		Node a = first;
		Node b = first;
		for(int i=0; i < k-1; i++)
			b = b.next;
		while(b != last) {
			a = a.next;
			b = b.next;
		}
		return a.value;
	}
	public void printMiddle() {
		if(isEmpty())
			throw new NoSuchElementException();
		Node a =first;
		Node b = first;
		while(a != last && b != last) {
			b= b.next.next;
			a = a.next;
		}
		if(b == last)
			System.out.println(a.value);
		else
			System.out.println(a.value + " " + a.next.value);
	}
}
