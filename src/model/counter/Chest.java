package model.counter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.food.*;
import model.player.Player;

public class Chest extends Counter {

	private int ingredient;
	static Image veg;
	static Image meat;
	static Image br;
	{
		veg = new Image("file:res/img/"+"counter"+9+".png");
		meat = new Image("file:res/img/"+"counter"+8+".png");
		br = new Image("file:res/img/"+"counter"+10+".png");
	}

	public Chest(double x, double y, int w, int h, int ingredient) {
		super(x, y, w, h);
		this.ingredient = ingredient;
	}
	
	@Override
	public boolean counterHaveFood() {
		return true;
	}
	
	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (foodOnCounter == null  && foodOnPlayer instanceof Ingredient) return true;
		return false;
	}
	
	@Override
	public IRenderableFood callIngredient(Player player) {
		if (foodOnCounter != null) {
			IRenderableFood c = foodOnCounter;
			foodOnCounter = null;
			return c; 
		} else {
			if (ingredient == Food.MEAT) return new Meat();
			else if (ingredient == Food.VEGETABLE)return new Vegetable();
			else return new Bread();
		}
	}
	
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(ingredient == Food.MEAT) {
			gc.drawImage(meat, x - width / 2, y - height, width, height);
		}
		else if(ingredient == Food.VEGETABLE) {
			gc.drawImage(veg, x - width / 2, y - height, width, height);

		}else {
			gc.drawImage(br, x - width / 2, y - height, width, height);

		}
		
		
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}
	
}
