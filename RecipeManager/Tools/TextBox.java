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
    
    public TextBox(App app) {
		this.app = app;
		this.date = LocalDate.now();
	    this.lastDate = 1;
	    this.lastMonth = 6;
	    this.latestDate = date.getDayOfMonth();
	    this.latestMonth = date.getMonthValue();
	    this.daysPerMonth = 31;
	}
	public void validate() {
		textPane = new JTextPane();
		textPane.setBounds(0, 0, 338, 123);
		textPane.setEditable(false);
		textPane.setFocusable(false);
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		textPane.setForeground(Color.black);
		textPane.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		app.panelList.get(4).add(textPane);

		if(StartupScreen.tracker_permission) {
			setTracker(lastDate, lastMonth, latestDate, latestMonth, "Feature was disabled by Developer since April of 2026, Functionality can be limited.");
		}else {
			setInformation("                        What's New: " + "\n                          - Imprecise Payment Bug Fix \n                          - Better Runtime                           \n   Released: 1.06.2026 " + "(Tracker Disabled)");
		}
	}
	private void setInformation(final String info) {
		textPane.setText(info);
	}
	private void setTracker(int lastDate, int lastMonth, int latestDate, int latestMonth, final String warningTip) {
		 textPane.setToolTipText(warningTip);
		 if(latestMonth > lastMonth && latestDate == lastDate) {
			 daysAgo = " (" + String.valueOf(latestMonth - lastMonth) + "mo)";
			 setInformation("                        What's New: " + "\n                          - Background Bug Fixes \n                          \n   Released: 1.06.2026" + daysAgo);
		 }else if(latestDate < lastDate) {
			 monthsAgo = " (" + (daysPerMonth - (lastDate -= latestDate)) + "d)";
			 setInformation("                        What's New: " + "\n                          - Background Bug Fixes \n                          \n   Released: 1.06.2026" + monthsAgo);
		 }
	} 
}
