package CodingBat.question.string;

//Given a string, if the first or last chars are 'x', return the string without those 'x' chars,
//		and otherwise return the string unchanged.
public class withoutX {
	public String withoutX(String str) {
		if(str.length()==0) return "";
		if(str.length()==1 && str.charAt(0)== 'x')	return "";
		if(str.length()==1) return str;
		char first = str.charAt(0);
		char last = str.charAt(str.length()-1);
		String left = str.substring(1,str.length()-1);
		
		if(first == 'x' && last == 'x')	return left;
		if(first == 'x')	 return (left + last);
		if(last == 'x') return (first + left);
		return (first+left+last);
	}

}
