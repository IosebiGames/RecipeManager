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
	    this.lastDate = 26;
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
		if(App.mode.equals("Dark")) {
			textPane.setForeground(Color.white);
		}else if(App.mode.equals("Light")) {
			textPane.setForeground(Color.black);
		}
		app.panelList.get(4).add(textPane);
		if(StartupScreen.tracker_permission) {
			textPane.setContentType("text/html");	
			textPane.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			setTracker(lastDate, lastMonth, latestDate, latestMonth, "Feature was disabled by Developer since April of 2026, Functionality can be limited.");
		}else {
			textPane.setContentType("text/html");	
			setInformation("<html><pre style='font-family:sans-serif; font-size:12px;'>"
				 + "                        What's New: " + "<br>"
				 + "                          - Imprecise Payment Bug Fix <br>"
				 + "                          - Better Runtime                           <br>"
				 + "   Released: 26.06.2026 " + "<font color='red'>(Tracker Disabled)</font>"
				 + "</pre></html>");
		}
	}
	private void setInformation(final String info) {
		textPane.setText(info);
	}
	private void setTracker(int lastDate, int lastMonth, int latestDate, int latestMonth, final String warningTip) {
		 textPane.setToolTipText(warningTip);
		 if(latestMonth > lastMonth && latestDate == lastDate) {
			 daysAgo = " (" + String.valueOf(latestMonth - lastMonth) + "mo)";
			 setInformation("                        What's New: " + "\n                          - Background Bug Fixes \n                          \n   Released: 26.06.2026" + daysAgo);
		 }else if(latestDate < lastDate) {
			 monthsAgo = " (" + (daysPerMonth - (lastDate -= latestDate)) + "d)";
			 setInformation("                        What's New: " + "\n                          - Background Bug Fixes \n                          \n   Released: 26.06.2026" + monthsAgo);
		 }else if(lastDate == latestDate && lastMonth == latestMonth) {
			 daysAgo = "(<font color='green'><b>Today</b></font>)";
			 setInformation("<html><pre style='font-family:sans-serif; font-size:11px;'>" + "                        What's New: <br>"  + "                          - Background Bug Fixes <br>"  + "                          <br>" + "   Released: 26.06.2026 " + daysAgo + "</pre></html>" + daysAgo);
		 }else if(lastDate == 0 && lastMonth == 0) {
			 textPane.setContentType("text/plain");
			 textPane.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
			 setInformation("\n   Tracker failed to load the last Update date. 🌧️");
		 }
	 }  
}
