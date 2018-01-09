package model;





import java.util.List;

import model.food.Food;

public class GameModel {
	private RenderableHolder renderableHolder;

	private Menu menu ;
	
	private static final long START_NANO_TIME = 180000000000L;
	
	static int score;
	long remainingNanoTime;
	
	public GameModel() {
		renderableHolder = new RenderableHolder();
		score = 0;
		remainingNanoTime = START_NANO_TIME;
		menu = new Menu();
		try{
			menu.generateMenu();
			menu.generateMenu();
			menu.generateMenu();
		}catch(Exception e) {
			
			e.printStackTrace();
			//System.out.println("Error?");
		}
	}
	
	public RenderableHolder getRenderableHolder() {
		return renderableHolder;
	}
	
	public List<IRenderable> getEntities() {
		return renderableHolder.entities;
	}
	
	public void decreaseRemainingTime(long decreasedNanoTime) {
		remainingNanoTime -= decreasedNanoTime;
	}
	
	public static int getScore() {
		return score;
	}
	
	public long getTimeNanosecond() {
		return remainingNanoTime;
	}
	
	public int getTimeSecond() {
		return (int) (remainingNanoTime / 1000000000);
	}
	
	public boolean serve(Food food) {
		if (menu.remove(food)) {
			if(food.getIngredient(Food.MEAT)==true) {
				score+=20;
			}
			if(food.getIngredient(Food.VEGETABLE)==true) {
				score+=10;
			}
			menu.generateMenu();
			System.out.println("correct menu");
			return true;
		} 
		System.out.println("incorrect menu");
		return false;
	}
	
	
	
	
}
