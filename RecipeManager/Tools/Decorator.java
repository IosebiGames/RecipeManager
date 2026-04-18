package Tools;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import main.App;
import recipeSystem.RecipeHandler;
import sound.Sound;

public class Decorator implements java.awt.event.ActionListener {
    private App app;
    private boolean showingNext = false;
    private Timer imageTimer;
    private int counter = 0;
    private JMenuItem Burgerpick, Drinkpick;
    private JPopupMenu popup1, popup2;
    private int addings = 0;
    private ResourceLoader rl;
    private Sound sound;
    private RecipeHandler rh;
    
    {
    	Burgerpick = new JMenuItem("Pick (60$)");
    	Drinkpick = new JMenuItem("Pick (90$)");
    	popup1 = new JPopupMenu();
    	popup2 = new JPopupMenu();
    }
    public Decorator(App app) {
        this.app = app;
        this.rl = new ResourceLoader();
        this.sound = new Sound();
        this.rh = new RecipeHandler(app);
    }
    public void decorate() {
    	try {
    		Burgerpick.setEnabled(true);
    		Burgerpick.setFocusable(false);
    		Burgerpick.setForeground(Color.black);
    		Burgerpick.setFont(new Font("Arial", Font.BOLD, 15));
    		Burgerpick.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				if(e.getSource()==Burgerpick) {
    					addings += 60;
    					Burgerpick.setText("Selecting more than once is disallowed, product is too expensive.");
    					app.labelList.get(12).setText("" + addings);
    					Burgerpick.setEnabled(false);					
    				}
    			}        	
    		});
    		Drinkpick.setFocusable(false);
    		Drinkpick.setForeground(Color.black);
     		Drinkpick.setFont(new Font("Arial", Font.BOLD, 15));
    		Drinkpick.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				if(e.getSource()==Drinkpick) {
    					addings += 90;
    					app.labelList.get(12).setText("" + addings);
    				}
    			}        	
    		});
    		popup1.add(Burgerpick);
    		popup1.setFocusable(false);
    		
    		popup2.add(Drinkpick);
    		popup2.setFocusable(false);
    		
    		app.labelList.get(2).setToolTipText("Burgers");
    		app.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Burger.png")));
    		app.labelList.get(2).setBorder(BorderFactory.createLineBorder(Color.black));
    		app.labelList.get(2).setComponentPopupMenu(popup1);
    		app.labelList.get(1).setToolTipText("Salads");
    		app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/TomatoSalad.png")));
    		app.labelList.get(1).setBorder(BorderFactory.createLineBorder(Color.black));
    		app.labelList.get(1).setComponentPopupMenu(popup2);
    		app.labelList.get(10).setFont(new Font("Arial", Font.BOLD, 15));
    		app.buttonList.get(5).addActionListener(this);
    	}catch(IOException e) {
           System.out.println("Failed to Decorate: " + e.getMessage());  		
    	}
    }
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == app.buttonList.get(5)) {
    	    Burgerpick.setText("Pick (60$)");
    		Burgerpick.setEnabled(true);
    		if (!showingNext) {
        		try {
        			app.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Steak.png")));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
                try {
                	app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/ChickenSalad.png")));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
                app.labelList.get(2).setToolTipText("Steak");
                app.labelList.get(1).setToolTipText("Chicken Salad");
                app.buttonList.get(5).setText("Back");
                showingNext = true;
                
                counter = 0;

                imageTimer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        counter++;
                        if (counter == 5) {
                            try {
                            	app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/IceCream.png")));
							} catch (IOException ex) {
								ex.printStackTrace();
							}
                            app.labelList.get(1).setToolTipText("Ice Cream");
                        }
                        if (counter == 12) {
                            try {
                            	app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/ChickenSalad.png")));
							} catch (IOException ex) {
								ex.printStackTrace();
							}
                            app.labelList.get(1).setToolTipText("Chicken Salad");
                            counter = 0; 
                        }
                    }
                });
                imageTimer.start();
            } else {
            	Burgerpick.setEnabled(true);
                try {
                	app.labelList.get(2).setIcon(new ImageIcon(rl.getImage("/images/Burger.png")));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
                try {
                	app.labelList.get(1).setIcon(new ImageIcon(rl.getImage("/images/TomatoSalad.png")));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
                app.labelList.get(2).setToolTipText("Burgers");
                app.labelList.get(1).setToolTipText("Salads");
                app.buttonList.get(5).setText("Next");
                showingNext = false;
                
                if (imageTimer != null) {
                    imageTimer.stop();
                    counter = 0;
                }
            }
        }
    }
}
