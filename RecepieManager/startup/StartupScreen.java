package startup;


import main.App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartupScreen {
	
	private JFrame window;
	private JProgressBar bar;
	private int procentage = 0;
	public Timer timer;
	private boolean startup_permission = true;
	
	public StartupScreen() {
	   window = new JFrame("Recepie Manager");
	   window.setResizable(false);
	   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   window.setPreferredSize(new Dimension(270, 100));
       window.pack();
       window.setLocationRelativeTo(null);
       window.setVisible(true);
       window.getContentPane().setLayout(null);
       window.setBackground(Color.white);
       
       setIcon(new ImageIcon(getClass().getResource("/images/icon.png")));

       bar = new JProgressBar();
       bar.setFocusable(false);
       bar.setString("Loading.....");
       bar.setStringPainted(true);
       bar.setValue(0);
       bar.setVisible(true);
       bar.setBounds(20, 8, 210, 40);
       bar.setBackground(Color.white);
       bar.setForeground(Color.red);
       window.add(bar);
     
       timer = new Timer(100, new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
    		   procentage++;
    		   bar.setValue(procentage);
    		   check(startup_permission);
    	   }			
       });
	}
	private void check(boolean p) {
		if(p) {
			if(procentage == 81) bar.setString("Almost there....");
			if(procentage == 91) bar.setString("Finishing up....");
			if(procentage == 97) bar.setString("Done....");
			if(procentage == 100) {
				procentage = 100; 
				window.dispose();
				new App();
			}
		}else {
			if(procentage == 81) bar.setString("Shutting down...");
			if(procentage == 91) System.exit(0);
		}
	}
	private void setIcon(ImageIcon icon) {
		window.setIconImage(icon.getImage());
    }
}