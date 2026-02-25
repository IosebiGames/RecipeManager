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
		textPane.setText("                                     What's New:" +
				"\n                                     - Adjusted Components\n                                     - Fixed Coordination\n                                     - Added Update Tracker System \n\n  Released: 24.02.2026\n  Version: 1.2v");
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		app.panelList.get(4).add(textPane);
		
		if(new Date().getDate() > 27) {
			textPane.setText("                                     What's New:" +
					"\n                                     - Adjusted Components\n                                     - Fixed Coordination\n                                     - Added Update Tracker System \n\n  Released: 24.02.2026 (" + "long time ago)" + "\n  Version: 1.2v");
		}else {
			textPane.setText("                                     What's New:" +
					"\n                                     - Adjusted Components\n                                     - Fixed Coordination\n                                     - Added Update Tracker System \n\n  Released: 24.02.2026 (" + (Math.round(currentDate) - lastDate) + " days ago)" + "\n  Version: 1.2v");	
		}
	}
}
