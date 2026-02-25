package Tools;

import java.awt.Rectangle;

public class Bounds {
	private Rectangle rect;
	
	public Bounds() {}
	public Bounds(int x, int y, int w, int h) {
		rect = new Rectangle(x, y, w, h);
	}
	public Rectangle getBounds() {
		return rect.getBounds();
	}
}
