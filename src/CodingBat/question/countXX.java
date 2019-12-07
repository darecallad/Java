package CodingBat.question;


//Count the number of "xx" in the given string. 
//We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
//
//countXX("abcxx") → 1
//countXX("xxx") → 2
//countXX("xxxx") → 3
public class countXX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countXX("abcxx"));
		System.out.println(countXX("xxx"));
		System.out.println(countXX("xxxx"));
	}
	
	public static int countXX(String str) {
		
	int count = 0;
	char[] result = new char[str.length()];
	
	for(int i = 0; i <str.length()-1; i ++) {
		result[i]= str.charAt(i);
		result[i+1] = str.charAt(i+1);
		if(result[i] == 'x' && result[i+1] == 'x')
			count++;
	}
	return count;
	}

}
