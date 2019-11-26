package interfface;

public class School2019 implements ISchool {
	
	private int count;
	
	public School2019(int count) {
		this.count=count;
	}

	@Override
	public int SchoolCount() {
		// TODO Auto-generated method stub
		return count;
	}

}
