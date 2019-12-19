package CodingBat.question.string;

//Given a string, return a "rotated right 2" version where the last 2 
//		chars are moved to the start. The string length will be at least 2.
//
//
//right2("Hello") → "loHel"
//right2("java") → "vaja"
//right2("Hi") → "Hi"
public class right2 {
	public String right2(String str) {
		  if(str.length()==2)
			  return str;
		  
		  String last2 = str.substring(str.length()-2,str.length());
		  String front = str.substring(0,str.length()-2);
		  return last2+front;
	}


}
