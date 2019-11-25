package projectdemo;

public class TextBox {
	//should not declare as public
	public String text = ""; //field
	// set " " in case it crash to point no where.
	
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void clear() {
		this.text = "";	// should use text = "";
	}
}
