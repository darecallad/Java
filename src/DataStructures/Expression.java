package DataStructures;

import java.util.List;
import java.util.Arrays;
import java.util.Stack;

public class Expression {
	private final List<Character> leftBrackets = Arrays.asList('(','<','[','{');
	private final List<Character> rightBrackets = Arrays.asList(')','>',']','}');

	public boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		for(char ch : input.toCharArray()) {
			if(isLeftBracket(ch))
				stack.push(ch);
			
			if(isRightBracket(ch)) {
				if(stack.empty()) return false;
				
				char top = stack.pop();
				if(!bracketsMatch(top,ch)) return false;
			}
		}
		return stack.empty();
	}

	private boolean bracketsMatch(char left, char right) {
		// TODO Auto-generated method stub
		return leftBrackets.indexOf(left) ==rightBrackets.indexOf(right);
	
	}

	private boolean isRightBracket(char ch) {
		// TODO Auto-generated method stub
		return rightBrackets.contains(ch);
	}

	private boolean isLeftBracket(char ch) {
		// TODO Auto-generated method stub
		
		return leftBrackets.contains(ch);
	}
	
	
}
