package model.counter;


import Utility.ResoureLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.food.Chopable;
import model.food.IRenderableFood;
import model.food.Ingredient;
import model.player.Player;

public class Chopper extends Counter {

	static boolean check;

	public Chopper(double x, double y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		check=false;
	}
	
	public void chopping() {
		Ingredient ingredient = (Ingredient) foodOnCounter;
		if (ingredient.getState() != model.food.Ingredient.CAN_CHOP) return;
		
		Chopable food = (Chopable) ingredient;
		food.addTimeToChopped();
		System.out.println("time of Chopped " + food.getTimeToChopped());
		if(food.getTimeToChopped()%10==0) {
			check=true;
		}
		if (food.getTimeToChopped() >= Chopable.TIMEFORCOMPLETECHOPPED) {
			food.setStateWhenCompleteChop();
			System.out.println("Ingredient is complete chopped");
		}
	}
	
	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (foodOnCounter == null && foodOnPlayer instanceof Chopable && foodOnPlayer instanceof Ingredient) {
			Ingredient ingredient = (Ingredient) foodOnPlayer;
			if (ingredient.getState() == model.food.Ingredient.CAN_CHOP) 
				return true;
		}
		return false;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if (foodOnCounter == null) gc.drawImage(ResoureLoader.counter[5],x-width/2, y-height, width, height);
		else gc.drawImage(ResoureLoader.counter[6],x-width/2, y-height, width, height);
			
	
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}
