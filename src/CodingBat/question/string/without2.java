package CodingBat.question.string;
//Given a string, if a length 2 substring appears at both its beginning and end, 
//return a string without the substring at the beginning, so "HelloHe" yields "lloHe".
//The substring may overlap with itself, so "Hi" yields "". Otherwise,
//return the original string unchanged.
public class without2 {
	public String without2(String str) {
		if(str.length() ==2) return "";
		if(str.length() == 1)	return str;
		if(str.length() == 0) return "";
		String first2 = str.substring(0,2);
		String left =str.substring(2);
		String last2 = str.substring(str.length()-2);
		if(first2.equals(last2))
			return left;
		return str;
	}

}
