package recipeSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import main.App;
import Tools.*;
import Tools.Button;
import Tools.Labels;
import Tools.Panel;
import sound.Sound;
import startup.StartupScreen;

public class MoreTab {
	private JFrame window;
    private App app;
    private Panel p;
    private RecipeHandler rh;
    private Labels l;
	private Button b;
	private Fonts f;
	private Timer resetTimer;
    private int counter = 0;
    private String[] text, labelTexts;
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
		this.b = new Button();
		this.f = new Fonts();
	    this.labelTexts = new String[] {"Product:", "Calories:", "Vitamins:", "Fats:", "Sodium:", "Protein:", "Water:", "Allergens:"};
    }
	public void openMoreTab() {
		for(int i = 0; i <= 7; i++) {
			labelList.add(new JLabel(labelTexts[i]));	
		}
		buttonList.add(new JButton("Request all Recipes"));
		buttonList.add(new JButton("Close"));
	    PanelList.add(new JPanel());
	    f.AllowExternalFont("src/fonts/Inter_bold.ttf");
	    
		resetTimer = new Timer(1000, _ -> {
			counter++;
			if(counter == 4) {
				counter = 0;
				if(App.mode.equals("Dark")) {
					buttonList.get(1).setBackground(Color.black);
				}else if(App.mode.equals("Light")) {
					buttonList.get(1).setBackground(Color.white);
				}
				resetTimer.stop();
			}
		});
		resetTimer.start();
		
		window = Screen.createWindow("More Info", false, true, 306, 459, JFrame.DO_NOTHING_ON_CLOSE, new ImageIcon(getClass().getResource("/images/icon.png")).getImage(), new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			     Toolkit.getDefaultToolkit().beep();
			     buttonList.get(1).setBackground(Color.red);
			     resetTimer.start();
			     return;
			}
		});
		p.createPanel(PanelList.get(0), new Bounds(29, 92, 239, 311).getBounds(), false);
		b.createButton(buttonList.get(0), new Bounds(10, 216, 170, 41).getBounds(), false, PanelList.get(0), true, Color.white, Color.black);
		b.createButton(buttonList.get(1), new Bounds(10, 260, 170, 41).getBounds(), false, PanelList.get(0), true, Color.white, Color.black);
		
		for(int i = 0; i <= 1; i++) {
			buttonList.get(i).setBackground(Color.white);
			buttonList.get(i).setForeground(Color.black);
		}
		l.createLabel(labelList.get(0), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(28, -19, 181, 63).getBounds(), false, null);
		l.createLabel(labelList.get(1), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(10, 51, 118, 51).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(2), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(10, 73, 177, 51).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(3), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(10, 136, 175, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(4), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(10, 96, 165, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(5), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(10, 116, 165, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(6), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(10, 156, 175, 41).getBounds(), false, PanelList.get(0));
		l.createLabel(labelList.get(7), createFont("Inter", Font.BOLD, 16), Color.black, new Bounds(10, 176, 175, 41).getBounds(), false, PanelList.get(0));
		
		productBox.setFocusable(false);
		productBox.setFont(createFont("Inter", Font.BOLD, 14));
		productBox.setBounds(new Bounds(88, 31, 170, 41).getBounds());
		productBox.addActionListener(e -> {
			  switch(productBox.getSelectedIndex()) {
			  case 0: displayInfo("Calories: 332", "Vitamin: B12, B6, Iron", "Protein: 26g", "Water: 60mg", "Sodium: 50g", "Fat: 17g (Satured 7g)", "Allergens: 1", "Product: " + "Meat"); break;
			  case 1: displayInfo("Calories: 120", "Vitamin: A, C, K, Folate", "Protein: 3g", "Sodium: 1.5g", "Water: 150g", "Fat: 4g", "Allergens: 1", "Product: " + "Tomato Salad"); break; 
			  case 2: displayInfo("Calories: 300", "Vitamin: C, A, K, Folate", "Protein: 30mg", "Sodium: 350mg", "Water: 160g", "Fat: 4g", "Allergens: 1", "Product: " + "Chicken Salad"); break;
			  case 3: displayInfo("Calories: 250", "Vitamin: A, Calcium", "Protein: 6g", "Sodium: 350mg", "Water: 0.7g", "Fat: 14g", "Allergens: 1", "Product: " + "Ice-Cream"); break;
			  case 4: displayInfo("Calories: 500", "Vitamin: C, K", "Protein: 15g", "Sodium: 400mg", "Water: 90g", "Fat: 25g", "Allergens: 2", "Product: " + "Burger"); break;
		    }
			if(e.getSource() == productBox) {
				new Sound().playSound("/sound/click_sound.wav");
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
			PanelList.get(0).add(labelList.get(1));
		}
		window.getContentPane().add(PanelList.get(0));
		window.getContentPane().add(labelList.get(0));
		window.getContentPane().add(productBox);
		
		if(App.mode.equals("Dark")) {
			StartupScreen.setMode("Dark",  null);
			for(int i = 0; i < labelList.size(); i++) {
                labelList.get(i).setForeground(Color.white);
			}
			buttonList.get(0).setForeground(Color.white);
			buttonList.get(0).setBackground(Color.black);
			buttonList.get(1).setForeground(Color.white);
			buttonList.get(1).setBackground(Color.black);
			return;
		}else if(App.mode.equals("Light")) {
			StartupScreen.setMode("Light",  null);
			for(int i = 0; i < labelList.size(); i++) {
                labelList.get(i).setForeground(Color.black);				
			}
			buttonList.get(0).setForeground(Color.black);
			buttonList.get(0).setBackground(Color.white);
			buttonList.get(1).setForeground(Color.black);
			buttonList.get(1).setBackground(Color.white);
            return;
		}
	}
	private Font createFont(String fontName, int type, int size) {
		return new Font(fontName, type, size);
	}
	private void displayInfo(String caloriesInf, String vitaminInf, String proteinInf, String sodiumInf, String waterInf, String fatInf, String allergenInf, String productInf) {
        text = new String[] {productInf, caloriesInf, vitaminInf, proteinInf, sodiumInf, fatInf, waterInf, allergenInf};
        for(int i = 0; i < text.length; i++) { 
            labelList.get(i).setText(text[i]);
       }
    }
}
