package model.counter;


import Utility.ResourseLoader;
import javafx.scene.canvas.GraphicsContext;
import model.food.Chopable;
import model.food.IRenderableFood;
import model.food.Ingredient;

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
		if(food.getTimeToChopped()>0 && food.getTimeToChopped()%10==0) {
			ResourseLoader.chop_sound.play();
			
		}
		System.out.println("time of Chopped " + food.getTimeToChopped());
		
		if (food.getTimeToChopped() >= Chopable.TIMEFORCOMPLETECHOPPED) {
			food.setStateWhenCompleteChop();
			check=false;
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
		if (foodOnCounter == null) gc.drawImage(ResourseLoader.counter[5],x-width/2, y-height, width, height);
		else gc.drawImage(ResourseLoader.counter[6],x-width/2, y-height, width, height);
			
	
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}
