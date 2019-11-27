package interfface;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double number = BookConsole.readNumber("Book Total: ", 0, 6);
		BookReport report = new BookReport();
		report.show(new BookNumber(number));
	}

}
