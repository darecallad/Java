package DataStructures;
import java.util.*;
public class buildHashTable {
	private class Entry{
		private int key;
		private String value;
		
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}// end Entry class
	
	private LinkedList<Entry>[] entries = new LinkedList[5];
	
	public void put(int key, String value) {
		int index = hash(key);
		if(entries[index] == null)//empty, first one then create new LinkedList
			entries[index] = new LinkedList<>();
		
		LinkedList<Entry> bucket = entries[index];
		for(Entry entry : bucket) {
			if(entry.key == key) {
				entry.value = value;
				return;
			}
		}
		
		// grab entry add into entry obj
		bucket.addLast(new Entry(key,value));
	}
	public String get(int key) { // also we first check index
		int index = hash(key);	// we create bucket Entry as LinkedList<Entry>
		LinkedList<Entry> bucket = entries[index];
		if(bucket != null) {	//if bucket isnt null
		for(Entry entry : bucket)	// we return key value;
			if(entry.key == key)
				return entry.value;
		}// else return null;
		return null;
	}
	public void remove(int key) {
		int index = hash(key);
		LinkedList<Entry> bucket = entries[index];
		if(bucket == null)	throw new IllegalStateException();
		
		for(Entry entry : bucket) {
			if(entry.key == key) {
				bucket.remove(entry);
				return;
				}
		}
		throw new IllegalStateException();
	}
	
	private int hash(int key) {
		return key % entries.length;
	}
}
