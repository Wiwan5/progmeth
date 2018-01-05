package model;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import Utility.Time;
import Utility.Pair;
import model.food.Food;

public class GameModel {
	private RenderableHolder renderableHolder;
	public CopyOnWriteArrayList<Pair<Food, Time>> currentMenu=  new CopyOnWriteArrayList();
	
	private Menu menu = new Menu();
	
	private static final long START_NANO_TIME = 180000000000L;
	
	static int score;
	long remainingNanoTime;
	
	public GameModel() {
		renderableHolder = new RenderableHolder();
		score = 0;
		remainingNanoTime = START_NANO_TIME;
		
		try{
			add();
			add();
			
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
		if (remove(food)) {
			if(food.getIngredient(1)==true) {
				score+=20;
			}
			if(food.getIngredient(2)==true) {
				score+=10;
			}
			add();
			System.out.println("correct menu");
			return true;
		} 
		System.out.println("incorrect menu");
		return false;
	}
	
	public boolean remove(Food food) {
		for(Iterator<Pair<Food,Time>> iter = currentMenu.iterator(); iter.hasNext();) {
			Pair<Food,Time> data = iter.next();
		    if (data.first.equals(food)) {
		        iter.remove();
				return true;
				
		    }
		}
		return false;			
	}
	public void add() {
		if(currentMenu.size()<5) {
			Pair<Food, Time> f=  menu.generateMenu();
			//System.out.println("Food = "+f.first.printFood());
			currentMenu.add(f);
		}
	}
	
	
}
