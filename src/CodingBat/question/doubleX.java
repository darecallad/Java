package CodingBat.question;


//Given a string, return true if the first instance of "x" 
//		in the string is immediately followed by another "x".
//
//
//doubleX("axxbb") → true
//doubleX("axaxax") → false
//doubleX("xxxxx") → true
public class doubleX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(doubleX("axxbb"));
		System.out.println(doubleX("axaxax"));
		System.out.println(doubleX("xxxxx"));
	}
	
	static boolean doubleX(String str) {
		int index = str.indexOf("x");
		if(index == -1)	return false;
		
		if((index +1) > str.length()-1) return false;
		
		return str.subSequence(index, (index+2)).equals("xx");
		  
	}


}
