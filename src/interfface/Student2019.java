package interfface;

public class Student2019 implements IStudent{

	private int count;
	
	public Student2019(int count) {
		this.count = count;
	}
	
	@Override
	public int classCount() {
		// TODO Auto-generated method stub
		return count;
	}

}
