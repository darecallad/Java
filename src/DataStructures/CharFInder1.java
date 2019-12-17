package DataStructures;
import java.util.*;
public class CharFInder1 {
	public char Charfinder(String str) {
		Map<Character,Integer> map = new HashMap<>();
		char[] chars = str.toCharArray();
		
		for(char ch : chars) {
			int count = map.containsKey(ch) ? map.get(ch) : 0;
			map.put(ch, count + 1);
		}
		for(char ch: chars) {
			if(map.get(ch) == 1)
				return ch;
		}
		return Character.MIN_VALUE;
	}
	public char findfirstrepeat(String str) {
		Set<Character> set = new HashSet<>();
		char[] chars = str.toCharArray();
		for(char ch : chars) {
			if(set.contains(ch))
				return ch;
			set.add(ch);
		}
		return Character.MIN_VALUE;
	}
	public char findfirstRhashMap(String str) {
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = str.toCharArray();
		for(char ch : chars) {
			int count = map.containsKey(ch) ? map.get(ch) : 0;
			map.put(ch, count + 1);
		}
		for(char ch : chars) {
			if(map.get(ch)> 1)
				return ch;
		}
		return Character.MIN_VALUE;
	}

}
