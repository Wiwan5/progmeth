package model;

import java.util.List;

import model.food.Food;

public class GameModel {
	private RenderableHolder renderableHolder;

	private Menu menu;

	private static final long START_NANO_TIME = 180000000000L;

	private static int score;
	long remainingNanoTime;

	public GameModel() {
		renderableHolder = new RenderableHolder();
		score = 0;
		remainingNanoTime = START_NANO_TIME;
		menu = new Menu();
		try {
			menu.generateMenu();
			menu.generateMenu();
			menu.generateMenu();
		} catch (Exception e) {

			e.printStackTrace();
			// System.out.println("Error?");
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
		int scoreBeforeAdd = 20;
		if (food.getIngredient(Food.MEAT) == true) {
			scoreBeforeAdd += 30;
		}
		if (food.getIngredient(Food.VEGETABLE) == true) {
			scoreBeforeAdd += 20;
		}
		if (menu.remove(food)) {
			score += scoreBeforeAdd;
			menu.generateMenu();
			//menu.amountPlate++;
			System.out.println("correct menu");
			return true;
		}
		
		System.out.println("incorrect menu");
		return false;
	}

}
