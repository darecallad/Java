package interfface;

public class Student2020 implements IStudent{

	private int count;
	
	public Student2020(int count) {
		this.count=count;
	}
	@Override
	public int classCount() {
		// TODO Auto-generated method stub
		return count;
	}

}
