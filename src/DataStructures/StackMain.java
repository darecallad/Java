package DataStructures;

public class StackMain {
	
	public static void main(String[] args) {
	String str = "abcdzz";
	StringReverser3 reverse = new StringReverser3();
	String reversed = reverse.reverse(str);
	System.out.println(reversed);
	String str1 = "()";
	Expression3 balance = new Expression3();
	System.out.println(balance.isBalanced(str1));
	Stack3 stack = new Stack3();
	stack.push(10);
	stack.push(20);
	stack.push(30);
	System.out.println(stack.toString());
	}
}
