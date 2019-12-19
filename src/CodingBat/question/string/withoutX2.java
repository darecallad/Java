package CodingBat.question.string;

//Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars,
//and otherwise return the string unchanged. This is a little harder than it looks.
public class withoutX2 {
	public String withoutX2(String str) {
		if(str.length()==0) return "";
		if(str.length()==1 && str.charAt(0) == 'x') return "";
		if(str.length()==1) return str;
		char first = str.charAt(0);
		char second = str.charAt(1);
		String left = str.substring(2);
		if(first == 'x' && second =='x') return left;
		if(first == 'x') return (str.substring(1,2) +left);
		if(second == 'x') return (str.substring(0,1) + left);
		return (str.substring(0,1)+str.substring(1,2)+left);
		
	}

}
