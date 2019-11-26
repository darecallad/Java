package interfface;

public class AreaReport {

	private IArea area;
	
	public void printArea(IArea area) {
		double result = area.calculateArea();
		System.out.println(result);
		
	}
}
