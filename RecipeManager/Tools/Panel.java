package Tools;

import javax.swing.*;
import java.awt.*;

public class Panel {

	private Screen screen;
	
	public Panel(Screen s) {
		this.screen = s;
	}
	public void createPanel(JPanel panel, Rectangle rect, boolean focusableStatus) {
		panel.setLayout(null);
		panel.setBounds(rect.getBounds());
		panel.setFocusable(focusableStatus);
	    addBorder(panel);
	    screen.window.add(panel);
	}
	public void addBorder(JPanel panel) {
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
