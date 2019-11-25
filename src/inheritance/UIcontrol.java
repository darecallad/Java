package inheritance;

public abstract class UIcontrol {
	private String text = "";
	protected boolean isEnabled = true;
	
//	public UIcontrol(boolean isEnabled) {
//		this.isEnabled = isEnabled;
//		System.out.println("UI CONTROL");
//	}
	public abstract void render();
	@Override
	public String toString() {
		return text;
	}
	public void enable() {
		isEnabled = true;
	}
	public void disable() {
		isEnabled = false;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

}
