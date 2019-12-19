package CodingBat.question.string;

//Given 2 strings, a and b, return a new string made of the first char of a and the last char of b, 
//so "yo" and "java" yields "ya". If either string is length 0, use '@' for its missing char.
public class lastChars {
	public String lastChars(String a, String b) {
	  		int alength = a.length();
			int blength = b.length();
			if(alength > 0 && blength >0) {
				String firsta = a.substring(0,1);
				String lastb = b.substring(b.length()-1);
				return firsta+lastb;
			}
			if(alength > 0 && blength == 0) {
				String firsta = a.substring(0,1);
				return firsta+"@";
			}
			if(alength==0 && blength >0) {
				String lastb = b.substring(b.length()-1);
				return "@"+lastb;
			}
			return "@@";

		  
	}


}
