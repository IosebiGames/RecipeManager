package Tools;

import javax.swing.*;
import java.awt.*;
import main.App;

public class TextBox {
	
	private JTextPane textPane;
	private App app;
	
	public TextBox(App app) {
	    this.app = app;
	    textPane = new JTextPane();
		textPane.setBounds(0, 0, 338, 123);
		textPane.setEditable(false);
		textPane.setForeground(Color.white);
		textPane.setBackground(Color.gray);
		textPane.setFocusable(false);
		textPane.setEnabled(false);
		textPane.setText("                                     What's New:" +
		                                                            "\n                                     - Vanilla Ice-Cream\n                                     - Meat Salad                                        \n                                     - Vegtable salad \n\n\n  Version:1.0v");
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		app.panels[4].add(textPane);
	}
}