package CodingBat.question.string;

//Given a string, return true if the first 2 chars in the string also appear at the end of the string,
//such as with "edited".
public class frontAgain {
	public boolean frontAgain(String str) {
		if(str.length() < 2) return false;
		  
		String first2 = str.substring(0,2);
		String last2 = str.substring(str.length()-2);
		if(first2.equals(last2))		return true;
		  
		return false;
	}

}
