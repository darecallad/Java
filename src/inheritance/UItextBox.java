package inheritance;

public class UItextBox extends UIcontrol{

	private String text = ""; //field
	// set " " in case it crash to point no where.
	
//	public UItextBox() {
//		super(true);
//		System.out.println("TEXTBOX");
//	}
//	
	@Override
	public void render() {
		System.out.println("Render TextBox");
	}
	@Override
	public String toString() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public void clear() {
		this.text = "";	// should use text = "";
	}
}

