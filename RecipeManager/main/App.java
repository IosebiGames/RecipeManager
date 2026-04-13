package main;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import Tools.*;
import recipeSystem.MoreTab;
import recipeSystem.RecipeHandler;
import startup.StartupScreen;

public class App {
	public Screen screen = new Screen();
	public Separators sp = new Separators(screen);
	public Labels lb = new Labels(screen);
	public TextBox tb = new TextBox(this);
    public Bounds b = new Bounds();
    private Panel panel = new Panel(screen);
    private Decorator dec = new Decorator(this);
    private RecipeHandler rh = new RecipeHandler(this);
    public MoreTab mt = new MoreTab(this, rh);
    private Button button = new Button(this, mt);
    public List<JLabel> labelList = new ArrayList<>();
    public List<JButton> buttonList = new ArrayList<>();
    public List<JPanel> panelList = new ArrayList<>();
    public List<Font> FontList = new ArrayList<>();
    private String[] labelTexts = {
    	    "Foods & Drinks", "", "",
    	    "Recipes", "", "", "", "", "",
    	    "Allergens:", "",
    	    "Total Sum:", "", "", "", "", "", "", ""};
    public static String[] buttonTexts = {"Burgers:", "Steak:", "Ice-Cream:", "Chicken Salad:", "Tomato Salad:", "Next", "More"};
    private final static String runtimeType = "User Runtime";
    private Font[] fonts = new Font[] {
    		new Font("Tahoma", Font.BOLD, 2), new Font("Sitka Text", Font.BOLD, 31), new Font("Trebuchet MS", Font.BOLD, 18)
    };
    private App(String runtimeType) {
    	if(runtimeType.equals("User Runtime") || runtimeType.equals("User Runtime".toLowerCase())) {
    	      StartupScreen.setMode("Dark");
    	      new startup.StartupScreen(this).timer.start();
        }else if(runtimeType.equals("Developer Runtime") || runtimeType.equals("Developer Runtime".toLowerCase())) {
    	      StartupScreen.setMode("Dark");
    	      new App();
        }
    }
    public App() { 
		 for(String labelText : labelTexts) {
			labelList.add(new JLabel(labelText));
		}for(String buttonText : buttonTexts) {
			buttonList.add(new JButton(buttonText));
		}for(int i = 0; i <= 4; i++) {
        	panelList.add(new JPanel());
        }for(Font font : fonts) {
        	FontList.add(font);
        }
        screen.createWindow();

		for(int i = 0; i < panelList.size(); i++) {
	        panel.createPanel(panelList.get(i), new Bounds(Bounds.panelXPostions[i], Bounds.panelYPostions[i], 338, Bounds.panelHeightPostions[i]).getBounds(), false);
		}
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
		lb.createLabel(labelList.get(11), FontList.get(1), new Color(255, 195, 51), new Bounds(86, 5, 171, 40).getBounds(), false, panelList.get(3));
		lb.createLabel(labelList.get(12), FontList.get(2), new Color(255, 192, 51), new Bounds(96, 38, 133, 14).getBounds(), false, panelList.get(3));
		
		button.createButton(buttonList.get(0), new Bounds(10, 93, 86, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black);
		button.createButton(buttonList.get(1), new Bounds(10, 124, 86, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black);
		button.createButton(buttonList.get(2), new Bounds(10, 153, 96, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black);
		button.createButton(buttonList.get(3), new Bounds(10, 183, 126, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black);
		button.createButton(buttonList.get(4), new Bounds(10, 213, 126, 23).getBounds(), false, panelList.get(1), true, Color.white, Color.black);
		button.createButton(buttonList.get(5), new Bounds(120, 214, 130, 40).getBounds(), false, panelList.get(0), true, Color.white, Color.black);
		button.createButton(buttonList.get(6), new Bounds(113, 133, 210, 40).getBounds(), false, panelList.get(2), false, Color.white, Color.black);

		for(int i = 0; i < Bounds.yPostions.length; i++) {
			sp.createSeparator(labelList.get(13+i), new Bounds(336, Bounds.yPostions[i], 115, 42).getBounds(), true);
		}
		dec.decorate();
	    rh.startRecipeSystem();
	    tb.validate(); 	    
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
	         new App(runtimeType);
		});
	}
 }
