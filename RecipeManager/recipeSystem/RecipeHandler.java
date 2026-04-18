package recipeSystem;

import javax.swing.*;
import Tools.Screen;

import java.awt.Font;
import java.io.*;
import main.App;

public class RecipeHandler {
    private App app;
    private int counter = 0, allergenAmount = 0;
    public Timer timer;
    private Screen screen;
    private MoreTab mt; 
    
    public RecipeHandler(App app) {
        this.app = app;
        this.screen = new Screen();
        
        timer = new Timer(1000, _ -> {
            counter++;
            if (counter == 10) {
                timer.stop();
                for (JButton b : app.buttonList) {
                    b.setEnabled(false);
                }
                counter = 0;
                allergenAmount = 0;
                for (int i = 4; i <= 8; i++) {
                    app.labelList.get(i).setText("");
                }
                app.labelList.get(9).setText("Allergens:");
                app.labelList.get(10).setText("0");

                for (int i = 0; i <= 4; i++) {
                    app.buttonList.get(i).setEnabled(true);
                }
                for(int i = 0; i <= 5; i++) {
                	app.buttonList.get(i).setEnabled(true);
                }
                app.buttonList.get(6).setVisible(false);
                app.buttonList.get(6).setEnabled(true);
            }
        });
    }
    public void startRecipeSystem() {
    	for(int i = 4; i <= 8; i++) {
    		app.labelList.get(i).setFont(new Font("Segoe UI", Font.BOLD, 11));
    	}
    	app.buttonList.get(6).addActionListener(_ -> {
            timer.stop();
            app.mt.openMoreTab();
            app.buttonList.get(6).setVisible(false);
            for (JButton b : app.buttonList) {
                b.setEnabled(false);
            }
        });
        app.buttonList.get(0).addActionListener(_ -> {
            if (!timer.isRunning()) {
                timer.start();
            }
            if (!timer.isRunning()) return;
            app.labelList.get(4).setText("beef patty, bun, lettuce, tomato");
            allergenAmount += 1;
            app.labelList.get(10).setText("" + allergenAmount);
            app.buttonList.get(0).setEnabled(false);
            app.buttonList.get(6).setVisible(true);
        });
        app.buttonList.get(1).addActionListener(_ -> {
            if (!timer.isRunning()) return;
            app.labelList.get(5).setText("beef, salt, pepper, garlic");
            allergenAmount += 1;
            app.labelList.get(10).setText("" + allergenAmount);
            app.buttonList.get(1).setEnabled(false);
        });
        app.buttonList.get(2).addActionListener(_ -> {
            if (!timer.isRunning()) return;
            app.labelList.get(6).setText("milk, cream, sugar, egg yolks");
            allergenAmount += 1;
            app.labelList.get(10).setText("" + allergenAmount);
            app.buttonList.get(2).setEnabled(false);
        });
        app.buttonList.get(3).addActionListener(_ -> {
            if (!timer.isRunning()) return;
            app.labelList.get(8).setText("mayonnaise, celery, lettuce");
            allergenAmount += 1;
            app.labelList.get(10).setText("" + allergenAmount);
            app.buttonList.get(3).setEnabled(false);
        });
        app.buttonList.get(4).addActionListener(_ -> {
            if (!timer.isRunning()) return;
            app.labelList.get(7).setText("tomato, olive oil, salt, vinegar");
            allergenAmount += 1;
            app.labelList.get(10).setText("" + allergenAmount);
            app.buttonList.get(4).setEnabled(false);
        });
    }
    public void writeAllergen(String fileName, String Allergen) {
        try {
            System.setOut(new PrintStream(fileName));
            System.out.println(Allergen);
        } catch (IOException e) {
            IO.println("Can't write Allergen: " + e.getMessage());
        }
    }
    public void writeRecipe(String fileName, String recipie) {
        try {
            System.setOut(new PrintStream(fileName));
            System.out.println(recipie);
        } catch (IOException e) {
            IO.println("Can't write Recipe: " + e.getMessage());
        }
    }
}
