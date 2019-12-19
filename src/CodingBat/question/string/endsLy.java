package CodingBat.question.string;
//Given a string, return true if it ends in "ly".
//
//
//endsLy("oddly") → true
//endsLy("y") → false
//endsLy("oddy") → false
public class endsLy {
	public static void main (String[] args) {
		String str= "evenly";
		String last2 = str.substring(str.length()-2);
		System.out.println(last2);
	}
	public boolean endsLy(String str) {
		if(str.length()<2)
			return false;
		
		String last2 = str.substring(str.length()-2);
		return last2.equals("ly");
	}

}
