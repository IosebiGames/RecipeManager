package recipeSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import Tools.*;
import Tools.Button;
import Tools.Labels;
import Tools.Panel;
import Tools.ResourceLoader;
import main.App;
import sound.Sound;
import com.formdev.flatlaf.*;

public class MoreTab {
	private JFrame window;
    private App app;
    private Panel p;
    private RecipeHandler rh;
    private Screen screen;
	private Labels l;
	private Button b;
	private ResourceLoader rl = new ResourceLoader();
	private Sound s = new Sound();
	private Timer resetTimer;
    private int counter = 0;
    
    public ArrayList<JLabel> labelList = new ArrayList<>();
    public ArrayList<JButton> buttonList = new ArrayList<>();
    public ArrayList<JPanel> PanelList = new ArrayList<>();
    private final String[] products = new String[] {"Meat", "Tomato Salad", "Chicken Salad", "Ice-Cream", "Burger"};
    private JComboBox<?> productBox = new JComboBox<>(products);
    
   public MoreTab(App app, RecipeHandler rh) {
		this.app = app;
		this.p = new Panel(app.screen);
		this.rh = rh;
		this.l = new Labels(app.screen);
		this.b = new Button(app, this);
	    this.screen = new Screen();
    }
	public void openMoreTab() {
		labelList.add(new JLabel("Product:"));
		labelList.add(new JLabel("Calories:"));
		labelList.add(new JLabel("Possible Vitamins:"));
		labelList.add(new JLabel("Fats:"));
		labelList.add(new JLabel("Sodium:"));
		labelList.add(new JLabel("Protein:"));
		labelList.add(new JLabel("Water Content:"));
		labelList.add(new JLabel("Allergens:"));
		buttonList.add(new JButton("Request all Recipes"));
		buttonList.add(new JButton("Close"));
	    PanelList.add(new JPanel());
	    
		resetTimer = new Timer(1000, _ -> {
			counter++;
			if(counter == 4) {
				counter = 0;
				buttonList.get(1).setBackground(Color.white);
				resetTimer.stop();
			}
		});
		resetTimer.start();
		window = new JFrame("More Information");
		window.setResizable(false);
		window.getContentPane().setLayout(null);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		
		window.setPreferredSize(new Dimension(306, 459));
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		try {
			window.setIconImage(new ImageIcon(rl.getImage("/images/icon.png")).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		window.addWindowListener(new WindowH());

		for(int i = 0; i <= 1; i++) {
			p.createPanel(PanelList.get(i-i), new Bounds(i+28, i+91, i+238, i+310).getBounds(), false);
			b.createButton(buttonList.get(i-i), new Bounds(i+9, i+215, i+169, i+40).getBounds(), false, PanelList.get(i-i), true, Color.white, Color.black);
			b.createButton(buttonList.get(i), new Bounds(i+9, i+259, i+169, i+40).getBounds(), false, PanelList.get(i-i), true, Color.white, Color.black);
		}
		for(int i = 0; i <= 1; i++) {
			buttonList.get(i).setBackground(Color.white);
			buttonList.get(i).setForeground(Color.black);
		}
		l.createLabel(labelList.get(0), createFont("Tahoma", Font.BOLD, 20), Color.black, new Bounds(88, -8, 161, 63 ).getBounds(), false, null);
		l.createLabel(labelList.get(1), createFont("Times New Roman", Font.BOLD, 18), Color.black,  new Bounds( 10, 31, 118, 51 ).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(2), createFont("Times New Roman", Font.BOLD, 16), Color.black, new Bounds(10, 73, 165, 51).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(3), createFont("Times New Roman", Font.BOLD, 18), Color.black,  new Bounds(10, 136, 175, 41 ).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(4), createFont("Times New Roman", Font.BOLD, 16), Color.black, new Bounds(10, 96, 165, 41 ).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(5), createFont("Times New Roman", Font.BOLD, 16), Color.black,  new Bounds( 10, 116, 165, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(6), createFont("Times New Roman", Font.BOLD, 16), Color.black, new Bounds( 10, 156, 175, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(7), createFont("Times New Roman", Font.BOLD, 16), Color.black, new Bounds(10, 176, 175, 41 ).getBounds(), false, PanelList.get(0));
		
		productBox.setFocusable(false);
		productBox.setBounds(new Bounds( 88, 41, 170, 41).getBounds());
		
		productBox.addActionListener(_ -> {
			  switch(productBox.getSelectedIndex()) {
			  case 0: displayInfo("Calories: 332", "Vitamin: B12, B6, Iron", "Protein: 26g", "Water: 60mg", "Sodium: 50g", "Fat: 17g (Satured 7g)", "Allergens: 1", "Meat"); break;
			  case 1: displayInfo("Calories: 120", "Vitamin: A, C, K, Folate", "Protein: 3g", "Sodium: 1.5g", "Water: 150g", "Fat: 4g", "Allergens: 1", "Tomato Salad"); break; 
			  case 2: displayInfo("Calories: 300", "Vitamin: C, A, K, Folate", "Protein: 30mg", "Sodium: 350mg", "Water: 160g", "Fat: 4g", "Allergens: 1", "Chicken Salad"); break;
			  case 3: displayInfo("Calories: 250", "Vitamin: A, Calcium", "Protein: 6g", "Sodium: 350mg", "Water: 0.7g", "Fat: 14g", "Allergens: 1", "Ice-Cream"); break;
			  case 4: displayInfo("Calories: 500", "Vitamin: C, K", "Protein: 15g", "Sodium: 400mg", "Water: 90g", "Fat: 25g", "Allergens: 2", "Burger"); break;
		    }
		});
		buttonList.get(0).addActionListener(e -> {
            if(e.getSource()==buttonList.get(0)) {
            	rh.writeRecipe("FoodRecipes.txt", "Meats: beef, salt, pepper, garlic. \nBurgers: beef patty, bun, lettuce, tomato. \nIce-Cream: milk, cream, sugar, egg yolks. \nTomato Salad: tomato, olive oil, salt, vinegar, onion. \nChicken Salad: mayonnaise, celery, lettuce. ");
            	rh.writeAllergen("FoodAllergens.txt", "Chicken Salad: Mayonnaise - can be allergic to some people, possible risk. \nlettuce - Pretty rare allergy. \nBurgers: Tomato - can be allergic to some people, low risk but possible. \nlettuce - Pretty rare allergy. \nMeats: Meat - can be allergic to some people, low risk in Many Regons but possible. \npepper - Pretty rare allergy. \nIce-Cream Milk - very high risk for someone with lactose intolerance. \nEgg yolks - Possible but rare allergy. Tomato: can be allergic to some people, low risk but possible. \nTomato Salad: olivie oil - No allergy but risky for people with high-cholesterol or digestive issues. \nChicken Salad: Mayonnaise - can be allergic to some people, possible risk. \nlettuce - Pretty rare allergy.");
            	buttonList.get(0).setEnabled(false);
            }
		});
		buttonList.get(1).addActionListener(_ -> {
		    	displayInfo("Calories:", "Possible Vitamins:", "Protein:", "Sodium", "Water Content:", "Fat:", "Allergens:", "Product:");
		    	for(JButton b : app.buttonList) {
		    		  b.setEnabled(false);
		    		  buttonList.get(0).setEnabled(true); 
		    		  rh.timer.restart();
		    		  window.dispose();
		    	}
		});
		for(int labelIndex = 1; labelIndex <= 7; labelIndex++) {
			PanelList.get(labelIndex-labelIndex).add(labelList.get(1));
		}
		window.getContentPane().add(PanelList.get(0));
		window.getContentPane().add(labelList.get(0));
		window.getContentPane().add(productBox);
		
  	  try {
		  UIManager.setLookAndFeel(new FlatDarkLaf());
	  } catch (UnsupportedLookAndFeelException e) {
		  System.out.println("Failed to load Look and Feel: " + e.getMessage());
	  }
	}
	private Font createFont(String fontName, int type, int size) {
		return new Font(fontName, type, size);
	}
	private class WindowH extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
		     Toolkit.getDefaultToolkit().beep();
		     buttonList.get(1).setBackground(Color.red);
		     resetTimer.start();
		}
	}
	private void displayInfo(String caloriesInf, String vitaminInf, String proteinInf, String sodiumInf, String waterInf, String FatInf, String allergenInf, String prodctInf) {
		labelList.get(0).setText(prodctInf);
		labelList.get(1).setText(caloriesInf);
		labelList.get(2).setText(vitaminInf);
		labelList.get(3).setText(proteinInf);
		labelList.get(4).setText(sodiumInf);
		labelList.get(5).setText(FatInf);
		labelList.get(6).setText(waterInf);
		labelList.get(7).setText(allergenInf);
 	}
}
