package interfface;

public class AreaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AreaReport report = new AreaReport();
		report.printArea(new TriArea(10));
		report.printArea(new SquarArea(10));
	}

}
