package Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Labels {
	private Screen screen;

	public Labels(Screen s) {
		this.screen = s;
	}
	public void createLabel(JLabel label, Font font, Color foregroundColor, Rectangle rect, boolean focusableStatus, JPanel partPanel) {
		label.setBounds(rect.getBounds());
		label.setFocusable(focusableStatus);
		label.setForeground(foregroundColor);
		label.setFont(font);
		this.screen.window.add(label);
		if (partPanel != null) {
			partPanel.add(label);
		}
	}
}
