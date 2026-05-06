package Tools;

import java.awt.Rectangle;

public class Bounds {
	private Rectangle rect;
	public static int[] yPostions = new int[] 
        	{26, 116, 214, 296, 378};
	public static int[] panelXPostions = new int[]
        	{0, 450, 450, 0, 0};
	public static int[] panelYPostions = new int[] 
        	{0, 0, 256, 378, 256};
	public static int[] panelHeightPostions = new int[] 
        	{256, 256, 189, 67, 122};
    public Bounds() {}
	public Bounds(int x, int y, int w, int h) {
		rect = new Rectangle(x, y, w, h);
	}
	public Rectangle getBounds() {
		return rect.getBounds();
	}
}
