package model.counter;



import Utility.ResourseLoader;
import javafx.scene.canvas.GraphicsContext;

import model.food.Bread;
import model.food.IRenderableFood;

import model.food.Meat;
import model.food.Plate;
import model.food.Vegetable;


public class Shelf extends Counter {
	private int image;
	public Shelf(double x, double y, int w, int h, IRenderableFood food,int i) {
		super(x, y, w, h);
		foodOnCounter = food;
		image = i;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (foodOnCounter == null) return true;
		else if (foodOnCounter instanceof Plate) {
			Plate plate = (Plate) foodOnCounter;
			if (plate.canSettleOnPlate(foodOnPlayer)) return true;
		} else if (foodOnPlayer instanceof Plate) {
			Plate plate = (Plate) foodOnPlayer;
			if (plate.canSettleOnPlate(foodOnCounter)) return true;
		}
		return false;
	}
	
	@Override
	public IRenderableFood setFoodOnCounter(IRenderableFood foodOnPlayer) {
		
		if (foodOnCounter == null) {
			foodOnCounter = foodOnPlayer;
		} else {
			if (foodOnPlayer instanceof Plate) {
				IRenderableFood temp = foodOnCounter;
				foodOnCounter = foodOnPlayer;
				foodOnPlayer = temp;
			}
			if (foodOnCounter instanceof Plate) {
				Plate plate = (Plate) foodOnCounter;
				if (foodOnPlayer instanceof Meat) 				plate.settleMeatOnPlate();
				else if (foodOnPlayer instanceof Vegetable) 	plate.settleVegtableOnPlate();
				else if (foodOnPlayer instanceof Bread) 		plate.settleBreadOnPlate();
			}
		}
		return null;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(image == 1) {
			gc.drawImage(ResourseLoader.counter[0],x-width/2, y-height, width, height);
		
		}
		else if(image ==2) {
			gc.drawImage(ResourseLoader.counter[1],x-width/2, y-height, width, height+25);
		}
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}
}
