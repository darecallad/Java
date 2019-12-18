package DataStructures;
import java.util.*;
public class buildHashTable3 {
	private class Entry{
		private int key;
		private String value;
		
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}// end Entry class
	
	LinkedList<Entry>[] entries = new LinkedList[5];
	
	public void put(int key , String value) {
		int index = hash(key);
		if(entries[index]== null)
			entries[index] = new LinkedList<>();
		
		LinkedList<Entry> bucket = entries[index];
		for(Entry entry : bucket) {
			if(entry.key == key) {
				entry.value = value;
				return;
			}
		}
		bucket.addLast(new Entry(key,value));
	}
	public String get(int key) {
		int index = hash(key);
		LinkedList<Entry> bucket = entries[index];
		if(bucket != null) {
			for(Entry entry : bucket) {
				if(entry.key == key)
					return entry.value;
			}
		}
		return null;
	}
	public void remove(int key) {
		
		
		int index = hash(key);
		LinkedList<Entry> bucket = entries[index];
		if(bucket == null) throw new IllegalStateException();
		for(Entry entry : bucket) {
			if(entry.key == key) {
				bucket.remove(entry);
				return;
			}
		}
		throw new IllegalStateException();
	}
	private Entry getEntry(int key) {
		int index = hash(key);
		LinkedList<Entry> bucket = entries[index];
		if(bucket != null) {
			for(Entry entry : bucket) {
				if(entry.key == key) {
					return entry;
				}
			}
			
		}
		return null;
	}
	
	private int hash(int key) {
		return key % entries.length;
	}

}
