package CodingBat.question.string;
//
//Given two strings, append them together (known as "concatenation") and return the result. 
//However, if the concatenation creates a double-char, then omit one of the chars, 
//so "abc" and "cat" yields "abcat".
public class conCat {
	public String conCat(String a, String b) {
		  int alen = a.length();
		  int blen = b.length();
		  if(alen == 0)	return b;
		  if(blen == 0)	return a;
		  if(alen == 0 && blen ==0) return "";
		  
		  char lasta = a.charAt(alen-1);
		  char firstb = b.charAt(0);
		  if(lasta ==firstb)
			   return a + b.substring(1);
		  return a+b;

			  
		  }
}
