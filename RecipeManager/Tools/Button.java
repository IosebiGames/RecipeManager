package Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sound.Sound;

public class Button {
	
	public void createButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible) {
        b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        
        for (ActionListener al : b.getActionListeners()) {
            b.removeActionListener(al);
        }
        b.addActionListener(_ -> new Sound().playSound());
        
        panel.add(b);
	}
	public void createSoundlessButton(JButton b, Rectangle rect, boolean focusableStatus, JPanel panel, boolean visible) {
        b.setFocusable(focusableStatus);
        b.setBounds(rect.getBounds());
        b.setVisible(visible);
        b.putClientProperty("JButton.buttonType", "roundRect");
        b.putClientProperty("FlatLaf.background", Color.white);
        b.putClientProperty("FlatLaf.foreground", Color.black);
        panel.add(b);
	}
}
