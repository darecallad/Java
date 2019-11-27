package interfface;

public class BookNumber implements IBook{

	private double number;
	public BookNumber(double number) {
		this.number = number;
		System.out.println("The total number is: ");
	}
	@Override
	public double bookNumber() {
		// TODO Auto-generated method stub
		return number;
	}

}
