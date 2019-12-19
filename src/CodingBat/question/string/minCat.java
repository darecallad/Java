package CodingBat.question.string;

//Given two strings, append them together (known as "concatenation") and 
//return the result. However, if the strings are different lengths, 
//omit chars from the longer string so it is the same length as the shorter string. 
//So "Hello" and "Hi" yield "loHi". The strings may be any length.
public class minCat {
	public String minCat(String a, String b) {
		int alen = a.length();
		int blen = b.length();
		if(alen > blen)	return a.substring(alen-blen) + b;
		if(alen< blen)	return a + b.substring(blen - alen);
		return a + b;
		
	}

}
