package learn;

public class Casting {

	public static void main(String[] args) {
		// IMplicit casting
		// byte > short > int > long > float > double
		short x = 1;
		int y = x +2;
		System.out.println(y);
		
		double a = 1.1;
		int b = (int)a +1;
		System.out.println(b);
		
		String xx = "1";
		// String to other type
		int yy = Integer.parseInt(xx)+1;
		System.out.println(yy);
		
	}
}
