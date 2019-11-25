package inheritance;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point other = (Point)obj;
			return other.x == x &&other.y == y;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
		
	}
}
