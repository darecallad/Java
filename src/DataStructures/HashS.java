package DataStructures;
import java.util.*;

public class HashS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<>();
		int[] numbers = {1,2,3,4,1,2,3,4,1,2,3,4};
		for(int number : numbers)
			set.add(number);
		System.out.println(set);

	}

}
