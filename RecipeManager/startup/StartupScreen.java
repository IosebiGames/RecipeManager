package startup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import Tools.Bounds;
import Tools.ResourceLoader;
import main.App;

public class StartupScreen {
	
	private JFrame window;
	private JProgressBar bar;
	private int procentage = 0;
	public Timer timer;
	private boolean startup_permission = true;
	
	public StartupScreen() {
	   window = new JFrame("Recipe Manager");
	   window.setResizable(false);
	   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   window.setPreferredSize(new Dimension(270, 100));
       window.pack();
       window.setLocationRelativeTo(null);
       window.setVisible(true);
       window.getContentPane().setLayout(null);
   
       try {
		setIcon(new ImageIcon(new ResourceLoader().getImage("/images/icon.png")));
	 } catch (IOException e) {
		e.printStackTrace();
     }

       bar = createBar("Loading.....", 0, true, new Bounds(20, 8, 210, 40).getBounds(), Color.white, Color.red, window, false, true, new Font("Roboto", Font.BOLD, 15));
     
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
	private JProgressBar createBar(String text, int value, boolean visible, Rectangle rect, Color bc, Color fg, JFrame window, boolean focusable, boolean extrab, Font f) {
		 bar = new JProgressBar();
		 bar.setFocusable(focusable);
		 bar.setValue(value);
		 bar.setString(text);
		 bar.setBounds(rect.getBounds());
		 bar.setBackground(bc);
		 bar.setForeground(fg);
		 bar.setStringPainted(extrab);
		 bar.setFont(f);
		 window.add(bar);
		 return bar;
	}
}
