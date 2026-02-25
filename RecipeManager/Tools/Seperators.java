package Tools;

import javax.swing.*;
import java.awt.*;

public class Seperators {
	private Screen screen;
	
	public Seperators(Screen s) {
		this.screen = s;
	}
	public void createSeperator(JLabel Seperatorlabel, Rectangle rect, boolean opaqueStatus) {
		Seperatorlabel.setBounds(rect.getBounds());
		Seperatorlabel.setOpaque(opaqueStatus);
        screen.window.add(Seperatorlabel);
	}
}
