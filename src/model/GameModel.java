package model;

import java.util.ArrayList;
import java.util.List;

import model.food.Food;

public class GameModel {
	private RenderableHolder renderableHolder;
	private List<Food> currentMenu;
	
	private static final long START_NANO_TIME = 120000000000L;
	
	private static int score;
	long remainingNanoTime;
	
	public GameModel() {
		renderableHolder = new RenderableHolder();
		score = 0;
		remainingNanoTime = START_NANO_TIME;
		
		currentMenu = new ArrayList<>();
		currentMenu.add(Menu.generateMenu());
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
		if (currentMenu.contains(food)) {
			score += 20;
			currentMenu.remove(food);
			System.out.println("correct menu");
			currentMenu.add(Menu.generateMenu());
			return true;
		} 
		System.out.println("incorrect menu");
		return false;
	}
}
