package DataStructures;
import java.util.*;
public class HaspTable {

	public static void main(String[] args) {
		// key and value
		// integer and employee's name
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Mosh");
		map.put(2, "john");
		System.out.println(map);
		// hash map no duplicate keys
		map.put(2, "Mary");
		System.out.println(map);
		
		
	}
}
