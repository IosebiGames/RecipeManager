package Tools;

import java.awt.Color;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;

import main.App;

public class TextBox {
	
	private JTextPane textPane;
    private int lastDate = 25;
    private int currentDate = new Date().getDate();
    private App app;
    
	public TextBox(App app) {
		this.app = app;
	}
	public final void validate() {
		textPane = new JTextPane();
		textPane.setBounds(0, 0, 338, 123);
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setEnabled(false);
		textPane.setText("                                     What's New:\" +\r\n"
				+ "					\"\\n                                     - Background Bug Fixes \\n\n  Released: 29.03.2026 \" + \"(Disabled)\" + \"\\\n  Version: 1.4v");
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		app.panelList.get(4).add(textPane);
		
		if(new Date().getDate() > 27) {
			textPane.setText("                                     What's New:" +
					"\n                                     - Background Bug Fixes \n  Released: 29.03.2026 " + "(Disabled)" + "\n  Version: 1.4v");
		}else {
			textPane.setText("                                     What's New:\" +\r\n"
					+ "					\"\\n                                     - Background Bug Fixes \\n\\  Released: 29.03.2026 \" + \"(Disabled)\" + \"\\n  Version: 1.4v");	
		}
	}
}
