package startup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Tools.Bounds;
import Tools.ResourceLoader;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import main.App;

public class StartupScreen {
	
	private JFrame window;
	private JProgressBar bar;
	private int procentage = 0;
	public Timer timer;
	private boolean startup_permission = true;
	public static boolean tracker_permission = false;
	
	public StartupScreen() {
	   window = new JFrame("RecipeManager");
	   window.setResizable(false);
	   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   window.setPreferredSize(new Dimension(270, 100));
       window.pack();
       window.setLocationRelativeTo(null);
       window.setVisible(true);
       window.getContentPane().setLayout(null);
       window.setIconImage(new ImageIcon(new ResourceLoader().getImage("/images/icon.png")).getImage());
       
       if(App.mode.equals("Dark")) {
    	   bar = createBar("Loading.....", 0, true, new Bounds(20, 8, 210, 40).getBounds(), Color.white, Color.red, window, false, true, new Font("Segoe UI", Font.BOLD, 15));
       }else if(App.mode.equals("Light")) {
    	   bar = createBar("Loading.....", 0, true, new Bounds(20, 8, 210, 40).getBounds(), Color.white, Color.red, window, false, true, new Font("Segoe UI", Font.BOLD, 15));
       }
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
	public static void setMode(String mode, String runtimeType) {
		if(runtimeType != null) {
			try {
				if(mode.equals("Light") && runtimeType.equals("User Runtime")) {
					setRuntimeState("Light", "User Runtime");
				}else if(mode.equals("Dark") && runtimeType.equals("User Runtime")) {
					setRuntimeState("Dark", "User Runtime");
				}else if(mode.equals("Light") && runtimeType.equals("Developer Runtime")) {
					setRuntimeState("Light", "Developer Runtime");
				}else if(mode.equals("Dark") && runtimeType.equals("Developer Runtime")) {
					setRuntimeState("Dark", "Developer Runtime");
				}
			}catch(UnsupportedLookAndFeelException e) {
                 System.out.println("Failed to set Mode: " + e.getMessage());				
			}
		}else {
			return;
		}
	}
	private static void setRuntimeState(String mode, String runtimeType) throws UnsupportedLookAndFeelException {
		  if(mode.equals("Light") || mode.equals("Light".toLowerCase()) && runtimeType.equals("User Runtime")) {
				UIManager.setLookAndFeel(new FlatLightLaf());		
				new startup.StartupScreen().timer.start();
		  }else if(mode.equals("Dark") || mode.equals("Dark".toLowerCase()) && runtimeType.equals("User Runtime")) {
				UIManager.setLookAndFeel(new FlatDarkLaf());
				new startup.StartupScreen().timer.start();
		  }else if(mode.equals("Light") || mode.equals("Light".toLowerCase()) && runtimeType.equals("Developer Runtime")) {
				UIManager.setLookAndFeel(new FlatLightLaf());				
				new App();
		  }else if(mode.equals("Dark") || mode.equals("Dark".toLowerCase()) && runtimeType.equals("Developer Runtime")) {
				UIManager.setLookAndFeel(new FlatDarkLaf());
		        new App();
		  }
	 }
}
