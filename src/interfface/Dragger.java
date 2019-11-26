package interfface;

public class Dragger {
					//UIWidget
	public void drag(Draggable draggable) {
		draggable.drag();
		
		System.out.println("DRAGGING DONE");
	}
}
