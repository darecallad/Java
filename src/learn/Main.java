package learn;

import java.awt.Point;
import java.util.Date;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		int age = 30;
		int temp = 50;
		System.out.println(age);
		System.out.println(temp);
		System.out.println();
		// integer can store with _ like 123_456_789
		
		int Countnumber = 123_234;
		System.out.println(Countnumber);
		
		// add with F to represent float
		// add with L to represent long
		
		float applePrice = 3.44F;		 // float
		long viewCount = 232_2132_431L;  // long
		//
		//
		
		System.out.println();
		Date now = new Date();
		System.out.println(now); 
		
		
		// reference obj
		Point point1 = new Point(1,2);
		Point point2 = point1;
		point1.x = 5;
		System.out.println(point2);
		
		//String is reference type in Java
		String message = new String("Hello World");
		System.out.println(message);
		//use for boolen message.endsWith("!!");
		// System.out.println(message.replace("!","*"));
		// ^^ this one return a new String
		// String in Java cannot be change
		// message.toLowerCase(); message.trim() get rid of useless space
		/////////////////////////////////////////////////////////////////
		// special Character using with \"
		// exp. c:\window\.... ----> "c:\\window\\....";
		
	}

}
