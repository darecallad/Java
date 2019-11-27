package interfface;

public class BookReport {
	IBook book;
	
	public void show(IBook book) {
		double number = book.bookNumber();
		System.out.println(number);
	}

}
