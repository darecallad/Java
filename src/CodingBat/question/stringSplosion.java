package CodingBat.question;

//Given a non-empty string like "Code" return a string like "CCoCodCode".
//
//
//stringSplosion("Code") → "CCoCodCode"
//stringSplosion("abc") → "aababc"
//stringSplosion("ab") → "aab"
public class stringSplosion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringSplosion("Code"));
	}
	public static String stringSplosion(String str) {
		  if(str.length()<1) return "";
		  String result = "";
		  for(int i =0; i < str.length(); i ++)
			  result = result + str.substring(0,i+1);
		  return result;
		  
	}
}
