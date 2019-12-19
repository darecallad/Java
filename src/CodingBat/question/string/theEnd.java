package CodingBat.question.string;

//Given a string, return a string length 1 from its front, unless front is false, 
//		in which case return a string length 1 from its back. The string will be non-empty.
//
//
//theEnd("Hello", true) → "H"
//theEnd("Hello", false) → "o"
//theEnd("oh", true) → "o"

public class theEnd {
	public String theEnd(String str, boolean front) {
		String first = str.substring(0,1);
		String last = str.substring(str.length()-1,str.length());
		if(front == true)	return first;
		else		return last;
		  
	}
}
