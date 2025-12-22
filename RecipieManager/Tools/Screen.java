package Tools;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Screen {
	
	public JFrame window;
	
	public void createWindow() {
		window = new JFrame("Recipie Manager");
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
}
