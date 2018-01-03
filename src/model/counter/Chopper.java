package model.counter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.food.Chopable;
import model.food.IRenderableFood;
import model.food.Ingredient;
import model.player.Player;

public class Chopper extends Counter {

	public static final int timeForCompleteChopped = 70;

	public Chopper(double x, double y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	public void chopping() {
		Ingredient ingredient = (Ingredient) foodOnCounter;
		if (ingredient.getState() != model.food.Ingredient.canChop) return;
		
		Chopable food = (Chopable) ingredient;
		food.addTimeToChopped();
		System.out.println("time of Chopped " + food.getTimeToChopped());
		if (food.getTimeToChopped() >= timeForCompleteChopped) {
			food.setStateWhenCompleteChop();
			System.out.println("Ingredient is complete chopped");
		}
	}
	
	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (foodOnCounter == null && foodOnPlayer instanceof Chopable && foodOnPlayer instanceof Ingredient) {
			Ingredient ingredient = (Ingredient) foodOnPlayer;
			if (ingredient.getState() == model.food.Ingredient.canChop) 
				return true;
		}
		return false;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.PINK);
		gc.fillRect(x-width/2, y-height, width, height);
		
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}
