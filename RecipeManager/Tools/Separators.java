package Tools;

import javax.swing.*;
import java.awt.*;

public class Separators {
	private Screen screen;
	
	public Separators(Screen s) {
		this.screen = s;
	}
	public void createSeparator(JLabel Seperatorlabel, Rectangle rect, boolean opaqueStatus) {
		Seperatorlabel.setBounds(rect.getBounds());
		Seperatorlabel.setIcon(new ImageIcon(getClass().getResource("/images/seperator_dark_icon.png")));
		Seperatorlabel.setOpaque(opaqueStatus);
		screen.window.add(Seperatorlabel);
	}
}
