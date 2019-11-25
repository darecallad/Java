package inheritance;

public class UIcontrolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UItextBox controler = new UItextBox();
		controler.disable();
		System.out.println(controler.isEnabled());
		
		UItextBox box1 = new UItextBox();
		//box1.setText("YEAH");
		UItextBox box2 = box1; // same memory 
		System.out.println(box1.hashCode());
		System.out.println(box2.toString());
		show(box1);
		
		UIcontrol[] controls = {new UItextBox(), new UIcheckbox()};
		for(UIcontrol control: controls) {
			control.render();
		}
	}
	
	public static void show(UIcontrol control) {
		UItextBox box1 = (UItextBox)control;
		box1.setText("Hi");
		System.out.println(control);
	}

}
