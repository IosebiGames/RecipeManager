package main;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import recipeSystem.MoreTab;
import recipeSystem.RecipeHandler;
import Tools.*;
import com.formdev.flatlaf.*;

public class App {
	public Screen screen = new Screen();
	public Seperators sp = new Seperators(screen);
	public Labels lb = new Labels(screen);
	public TextBox tb = new TextBox(this);
	public MoreTab mt = new MoreTab(this);
    public Bounds b = new Bounds();
    private Panel panel = new Panel(screen);
    private Button button = new Button();
    private Decorator dec = new Decorator(this);
    private RecipeHandler rh = new RecipeHandler(this);
    
    public ArrayList<JLabel> labelList = new ArrayList<>();
    public ArrayList<JButton> buttonList = new ArrayList<>();
    public ArrayList<JPanel> panelList = new ArrayList<>();
    public ArrayList<Font> FontList = new ArrayList<>();
    
	public App() { 
		labelList.add(new JLabel("Foods & Drinks"));
		labelList.add(new JLabel(""));
		labelList.add(new JLabel(""));
		labelList.add(new JLabel("Recipes"));
		labelList.add(new JLabel(""));
		labelList.add(new JLabel(""));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel("Allergens:"));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel("Total Sum:"));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel(""));
        labelList.add(new JLabel("")); 
        labelList.add(new JLabel(""));
        labelList.add(new JLabel(""));
		
		buttonList.add(new JButton("Burgers:"));
		buttonList.add(new JButton("Steak:"));
		buttonList.add(new JButton("Ice-Cream:"));
		buttonList.add(new JButton("Chicken Salad:"));
		buttonList.add(new JButton("Tomato Salad:"));
		buttonList.add(new JButton("Next"));
		buttonList.add(new JButton("More"));

		panelList.add(new JPanel());
		panelList.add(new JPanel());
		panelList.add(new JPanel());
		panelList.add(new JPanel());
		panelList.add(new JPanel());
	
		FontList.add(new Font("Tahoma", Font.BOLD, 2));
		FontList.add(new Font("Sitka Text", Font.BOLD, 31));
		FontList.add(new Font("Trebuchet MS", Font.BOLD, 18));
	
		screen.createWindow();

		panel.createPanel(panelList.get(0), new Bounds(0, 0, 338, 256).getBounds(), false);
		panel.createPanel(panelList.get(1), new Bounds(450, 0, 338, 256).getBounds(), false); 
		panel.createPanel(panelList.get(2), new Bounds(450, 256, 338, 189).getBounds(), false);
		panel.createPanel(panelList.get(3), new Bounds(0, 378, 338, 67).getBounds(), false);
		panel.createPanel(panelList.get(4), new Bounds(0, 256, 338, 122).getBounds(), false); 
		
		lb.createLabel(labelList.get(0), FontList.get(1), Color.yellow, new Bounds(48, 11, 260, 54).getBounds(), false, panelList.get(0));
		lb.createLabel(labelList.get(1), null, null, new Bounds(187, 64, 151, 144).getBounds(), false, panelList.get(0));
		lb.createLabel(labelList.get(2), null, null, new Bounds(10, 64, 151, 144).getBounds(), false, panelList.get(0));
		lb.createLabel(labelList.get(3), FontList.get(1), Color.green, new Bounds(114, 11, 151, 54).getBounds(), false, panelList.get(1));
		lb.createLabel(labelList.get(4), null, null, new Bounds(104, 99, 176, 18).getBounds(), false, panelList.get(1));
		lb.createLabel(labelList.get(5), null, null, new Bounds(104, 128, 176, 18).getBounds(), false, panelList.get(1));
		lb.createLabel(labelList.get(6), null, null, new Bounds( 109, 157, 176, 18).getBounds(), false, panelList.get(1));
		lb.createLabel(labelList.get(7),null, null, new Bounds(140, 213, 166, 23).getBounds(), false, panelList.get(1));
		lb.createLabel(labelList.get(8), null, null, new Bounds( 140, 183, 166, 23).getBounds(), false, panelList.get(1));
		lb.createLabel(labelList.get(9), FontList.get(1), Color.red, new Bounds(93, 11, 210, 54).getBounds(), false, panelList.get(2));
		lb.createLabel(labelList.get(10), null, null, new Bounds(93, 63, 145, 14).getBounds(), false, panelList.get(2));
		lb.createLabel(labelList.get(11), FontList.get(1), Color.blue, new Bounds(86, 0, 171, 40).getBounds(), false, panelList.get(3));
		lb.createLabel(labelList.get(12), FontList.get(2), Color.blue, new Bounds( 96, 38, 133, 14).getBounds(), false, panelList.get(3));
		
		button.createButton(buttonList.get(0), new Bounds(10, 93, 86, 23).getBounds(), false, panelList.get(1), true);
		button.createButton(buttonList.get(1), new Bounds(10, 124, 86, 23).getBounds(), false, panelList.get(1), true);
		button.createButton(buttonList.get(2), new Bounds(10, 153, 96, 23).getBounds(), false, panelList.get(1), true);
		button.createButton(buttonList.get(3), new Bounds(10, 183, 126, 23).getBounds(), false, panelList.get(1), true);
		button.createButton(buttonList.get(4), new Bounds(10, 213, 126, 23).getBounds(), false, panelList.get(1), true);
		button.createButton(buttonList.get(5), new Bounds(120, 214, 130, 40).getBounds(), false, panelList.get(0), true);
		button.createButton(buttonList.get(6), new Bounds(113, 133, 210, 40).getBounds(), false, panelList.get(2), false);
		
		for(int i = 0; i <= 6; i++) {
			buttonList.get(i).setBackground(Color.white);
			buttonList.get(i).setForeground(Color.black);
		}
		for(int i = 13; i <= 17; i++) {
			labelList.get(i).setBackground(Color.black);
		    labelList.get(i).setFont(FontList.get(i-i));
		}
		sp.createSeperator(labelList.get(13), new Bounds(338, 26, 115, 42).getBounds(), true);
		sp.createSeperator(labelList.get(14), new Bounds(338, 116, 115, 42).getBounds(), true);
		sp.createSeperator(labelList.get(15), new Bounds(338, 214, 115, 42).getBounds(), true);
		sp.createSeperator(labelList.get(16), new Bounds(338, 296, 115, 42).getBounds(), true);
		sp.createSeperator(labelList.get(17), new Bounds(338, 378, 115, 42).getBounds(), true);
		
	    try {
			dec.decorate();
		} catch (IOException e) {
		    System.out.println("Failed to decorate: " + e.getMessage());
		}
	    rh.startRecipeSystem();
	    
	    tb.validate(); 
	}
	public static void main(String[] args) {
	      UserRuntime();
	}
	private static void UserRuntime() {
	      javax.swing.SwingUtilities.invokeLater(() -> {
	    	  try {
	    		  UIManager.setLookAndFeel(new FlatDarkLaf());
	    	  } catch (UnsupportedLookAndFeelException e) {
	    		  System.out.println("Failed to load Look and Feel: " + e.getMessage());
	    	  }
			 new startup.StartupScreen().timer.start();
	     });
	}
	private static void DeveloperRuntime() {
		javax.swing.SwingUtilities.invokeLater(() -> {
	    	  try {
	    		  UIManager.setLookAndFeel(new FlatDarkLaf());
	    	  } catch (UnsupportedLookAndFeelException e) {
	    		  System.out.println("Failed to load Look and Feel: " + e.getMessage());
	    	  }
			 new App();
	     });
	}
}
