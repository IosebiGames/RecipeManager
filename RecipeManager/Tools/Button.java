package Tools;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import main.App;
import sound.Sound;
import recipeSystem.MoreTab;

public class Button {
	private App app;
	private MoreTab mt;
	private Sound sound;
	
	public Button(App app, MoreTab mt) {
		this.app = app;
		this.mt = mt;
		this.sound = new Sound();
	}
	public void createButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible, Color bc, Color fc) {
        b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        b.setFont(new Font("Arial", Font.BOLD, 12));
        b.setBackground(bc);
        b.setForeground(fc);
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        
        for (ActionListener al : b.getActionListeners()) {
            b.removeActionListener(al);
        }
        b.addActionListener(e -> {
        	if(e.getSource() == b) {
                try {
					new Sound().playSound("/sound/click_sound.wav");
				} catch (Exception ex) {
					System.out.println("Failed to play sound: " + ex.getMessage());
				}
        	}
        });
        panel.add(b);
	}
	public void createSoundlessButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible, Color bc, Color fc) {
        b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        b.setFont(new Font("Arial", Font.BOLD, 12));
        b.setBackground(bc);
        b.setForeground(fc);
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        panel.add(b);
	}
	public Border setBorder(Color c) {
		return BorderFactory.createLineBorder(c);
	}
}
