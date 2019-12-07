package DataStructures;

public class twoStack {

	private int count1 =0;
	private int count2 =0;
	
	private int[] item1 =new int[5];
	private int[] item2 = new int[5];
	
	public void push1(int item) {
		if(item1.length == count1)
			throw new StackOverflowError();
		item1[count1++] = item;
	}
	public void push2(int item) {
		if(item2.length == count2)
			throw new StackOverflowError();
		item2[count2++] = item;
	}
	
}
