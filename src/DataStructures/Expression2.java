package DataStructures;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression2 {
	private List<Character> LeftBrackets = Arrays.asList('(','<','[','{');
	private List<Character> RightBrackets = Arrays.asList(')','>',']','}');
	
	public boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch: input.toCharArray()) {
			if(isLeftBrackets(ch))
				stack.push(ch);
			
			if(isRightBrackets(ch)) {
				if(stack.empty()) return false;
				char top = stack.pop();
				if(!isMatchBalance(top,ch)) return false;
			}
		}
		return stack.empty();
	}
	private boolean isLeftBrackets(char ch) {
		return LeftBrackets.contains(ch);
	}
	private boolean isRightBrackets(char ch) {
		return RightBrackets.contains(ch);
	}
	private boolean isMatchBalance(char left, char right) {
		return LeftBrackets.indexOf(left) == RightBrackets.indexOf(right);
	}

}
