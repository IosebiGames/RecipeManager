package Tools;

import javax.swing.*;
import java.awt.*;
import main.App;

public class TextBox {
	private JTextPane textPane;

	public TextBox(App app) {
	    textPane = new JTextPane();
		textPane.setBounds(0, 0, 338, 123);
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setEnabled(false);
		textPane.setText("                                     What's New:" +
		                                                            "\n                                     - Improved Sound\n                                     - Dark & Light Mode\n                                     - Removed resource dependency \n\n  Released:7.02.2026\n  Version:1.1v");
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		app.panels[4].add(textPane);
	}
	public final void validate() {}
}
