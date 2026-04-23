package Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.io.IOException;

public class Screen {
	public JFrame window;
	private static JFrame anotherWindow;
	
	public Screen() {
		window = new JFrame("RecipeManager");
	}
	public void createWindow() {
		window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(804, 484));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.getContentPane().setLayout(null);
        
        try {
			setIcon(new ImageIcon(new ResourceLoader().getImage("/images/icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void setIcon(ImageIcon icon) {
		window.setIconImage(icon.getImage());
	}
	public static JFrame createWindow(String title, boolean resizable, boolean visible, int w, int h, int closeOperation, Image icon, WindowAdapter WindowH) {
		anotherWindow = new JFrame(title);
		anotherWindow.setResizable(resizable);
		anotherWindow.getContentPane().setLayout(null);
		anotherWindow.setDefaultCloseOperation(closeOperation);
		anotherWindow.setPreferredSize(new Dimension(w, h));
		anotherWindow.pack();
		anotherWindow.setLocationRelativeTo(null);
		anotherWindow.setVisible(visible);
	    anotherWindow.setIconImage(icon);
	    anotherWindow.addWindowListener(WindowH);
	    return anotherWindow;
	}
}
