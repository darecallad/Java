package interfface;

public class SquarArea implements IArea {

	private double longg;
	
	public SquarArea(double longg) {
		this.longg = longg;
		System.out.println("This is Squar.");
	}
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return longg * longg;
	}

}
