package Tools;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import startup.StartupScreen;
import main.App;

public class TextBox {
	private JTextPane textPane;
    private App app;
    private int lastDate;
    private int latestDate;
    private int lastMonth;
    private int latestMonth;
    private int daysPerMonth;
    private String daysAgo, monthsAgo;
    private LocalDate date;
    private StartupScreen startupS;
    
    public TextBox(App app) {
		this.app = app;
		this.date = LocalDate.now();
	    this.lastDate = 2;
	    this.lastMonth = 5;
	    this.latestDate = date.getDayOfMonth();
	    this.latestMonth = date.getMonthValue();
	    this.daysPerMonth = 30;
	    this.startupS = new StartupScreen("Update Tracker Availible!");
	}
	public void validate() {
		textPane = new JTextPane();
		textPane.setBounds(0, 0, 338, 123);
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setEnabled(false);
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		textPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		app.panelList.get(4).add(textPane);

		if(startupS.tracker_permission) {
			setTracker(lastDate, lastMonth, latestDate, latestMonth, "Feature was disabled by Developer since April of 2026, Functionality can be limited.");
		}else {
			setInformation("                        What's New: " + "\n                          - Background Bug Fixes \n                          \n   Released: 2.05.2026");
		}
	}
	private void setInformation(final String info) {
		textPane.setText(info);
	}
	//Unmaintained regions
	private void setTracker(int lastDate, int lastMonth, int latestDate, int latestMonth, final String warningTip) {
		 textPane.setToolTipText(warningTip);
		 if(lastMonth < latestMonth) {
	        monthsAgo = " (" + (latestMonth -= lastMonth) + "mo)";
	        setInformation("                                             What's New: " + "\n                          - Background Bug Fixes \n\n\n\n\n   Released: 9.04.2026" + monthsAgo);
		 }else if(lastDate > latestDate) {
			daysPerMonth = daysPerMonth - (lastDate -= latestDate);
			daysAgo = " (" + daysPerMonth + "d)";
			setInformation("                                             What's New: " + "\n                          - Background Bug Fixes \n\n\n\n\n   Released: 9.04.2026" + daysAgo);
		}
	} 
}
