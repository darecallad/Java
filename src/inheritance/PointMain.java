package inheritance;

public class PointMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point point1 = new Point(1,2);
		Point point2 = new Point(1,2);
		System.out.println(point1.equals(point2)); //reference
		System.out.println(point1.hashCode());
		System.out.println(point2.hashCode());
	}

}
