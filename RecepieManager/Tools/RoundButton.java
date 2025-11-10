package Tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class RoundButton extends JButton {
		private static final long serialVersionUID = 1L;
		public RoundButton(String text) {
	        super(text);
	        setFocusable(false);
	        setContentAreaFilled(false);
	        setBorderPainted(false);
	    }
	    public void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        if (getModel().isArmed()) {
	            g2.setColor(getBackground().darker());
	        } else {
	            g2.setColor(getBackground());
	        }
	        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
	        super.paintComponent(g2);
	        g2.dispose();
	    }
	}