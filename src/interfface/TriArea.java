package interfface;

public class TriArea implements IArea {

	private double longg;
	
	public TriArea(double longg) {
		this.longg = longg;
		System.out.println("This is Triangle. ");
	}
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		
		return longg * longg / 2;
	}

}
