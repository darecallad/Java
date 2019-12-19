package CodingBat.question.string;
//Given a string, return a version without the first 2 chars. 
//Except keep the first char if it is 'a' and keep the second char if it is 'b'.
//The string may be any length. Harder than it looks.
public class deFront {
	public String deFront(String str) {
		if(str.length() == 0) return "";
		if(str.length() == 1 && str.charAt(0)=='a')	return "a";
		
		char first = str.charAt(0);
		char second = str.charAt(1);
		String left = str.substring(2);
		if(first =='a' && second == 'b')return str;
		if(first =='a') return "a"+left;
		if(second == 'b') return "b" +left;
		return left;
	}


}
