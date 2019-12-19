package CodingBat.question.string;

//Given a string of any length, return a new string where the last 2 chars, if present, 
//are swapped, so "coding" yields "codign".
public class lastTwo {
	public String lastTwo(String str) {
		  int len = str.length();
		  if(len <= 1) return str;
		  if(len == 2) return str.substring(1) +str.substring(0,1);
		  
		  return str.substring(0,len-2) + str.substring(len-1) + str.substring(len-2,len-1);
	}

}
