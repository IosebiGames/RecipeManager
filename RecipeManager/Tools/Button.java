package Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sound.Sound;

public class Button {
	private Fonts f;

	public void createButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible, Color bc, Color fc) {
        f = new Fonts();
        f.AllowExternalFont("src/fonts/Inter_bold.ttf");
        b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        b.setFont(new Font("Inter", Font.BOLD, 12));
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
        		new Sound().playSound("/sound/click_sound.wav");
        	}
	    });
        panel.add(b);
	}
	public void createSoundlessButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible, Color bc, Color fc) {
		f = new Fonts();
        f.AllowExternalFont("src/fonts/Inter_bold.ttf");
		b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        b.setFont(new Font("Inter", Font.BOLD, 12));
        b.setBackground(bc);
        b.setForeground(fc);
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        panel.add(b);
	}
}
