package model.counter;

import model.Entity;
import model.food.IRenderableFood;
import model.player.Player;

public abstract class Counter extends Entity {
	protected IRenderableFood foodOnCounter;
	
	public abstract boolean canSettle(IRenderableFood foodOnPlayer);
	
	public Counter(double x, double y, int w, int h) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		foodOnCounter = null;
	}
	
	public IRenderableFood callIngredient(Player player) {
		IRenderableFood c = foodOnCounter;
		foodOnCounter = null;
		return c;
	}
	
	public boolean counterHaveFood() {
		if (foodOnCounter != null) return true;
		return false;
	};
	
	public void setFoodOnCounter(IRenderableFood food) {
		foodOnCounter = food;
	}
	
	public int getWidth()	{return width;}
	
	public int getHeight()	{return height;}
	
	public double getX()	{return x;}
	
	public double getY()	{return y;}
}
