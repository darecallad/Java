package CodingBat.question.string;

//Given a string, return true if "bad" appears starting at index 0 or 1 in the string,
//		such as with "badxxx" or "xbadxx" but not "xxbadxx". 
//		The string may be any length, including 0. Note: use .equals() to compare 2 strings.
//
//
//hasBad("badxx") → true
//hasBad("xbadxx") → true
//hasBad("xxbadxx") → false
public class hasBad {
	public boolean hasBad(String str) {
		if(str.length()<3) return false;
		
		String first3 = str.substring(0,3);
		if(str.length()>=4) {
		String second3 = str.substring(1,4);
		
		if(str.length() ==3 && str.subSequence(1, 2).equals("b"))		return false;
		
		return first3.equals("bad") || second3.equals("bad");}
		
		return first3.equals("bad");
		
	}


}
