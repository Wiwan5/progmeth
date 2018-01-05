package model.food;

import Utility.ResoureLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Vegetable extends Ingredient implements Chopable{
	private int timeToChopped;
	
	public Vegetable() {
		state = CAN_CHOP;
		timeToChopped = 0; 
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc, double x, double y) {
		gc.setFill(Color.GREENYELLOW);
		if (state == CAN_CHOP) {
			if(timeToChopped>=55&&timeToChopped<=70) {
				gc.drawImage(ResoureLoader.veg[6],  x-30, y-60,55, 50);
			}
			else if(timeToChopped>=50&&timeToChopped<55) {
				gc.drawImage(ResoureLoader.veg[5], x-30, y-60,55, 50);
			}
			else if(timeToChopped>=40&&timeToChopped<50) {
				gc.drawImage(ResoureLoader.veg[4],  x-30, y-60,55, 50);
			}
			else if(timeToChopped>=30&&timeToChopped<40) {
				gc.drawImage(ResoureLoader.veg[3],  x-30, y-60,55, 50);
			}
			else if(timeToChopped>=20&&timeToChopped<30) {
				gc.drawImage(ResoureLoader.veg[2], x-30, y-60,55, 50);
			}
			else if(timeToChopped>=10&&timeToChopped<20) {
				gc.drawImage(ResoureLoader.veg[1],  x-30, y-60,55, 50);
			}
			else if(timeToChopped>=0&&timeToChopped<10) {
				gc.drawImage(ResoureLoader.veg[0], x-30, y-60,55, 50);
				
			}
			if (timeToChopped >= 1) {
				gc.setFill(Color.LIGHTGRAY);
				gc.fillRect(x-20, y-40, 30, 5);
				gc.setFill(Color.GREEN);
				gc.fillRect(x-20, y-40, (double) (timeToChopped/7*3), 5);
			}
		} else if (state == COOKED) { 
			gc.drawImage(ResoureLoader.veg[7], x-25, y-60,50, 45);
		}
	}

	@Override
	public void addTimeToChopped() {
		timeToChopped++;
	}

	@Override
	public void setStateWhenCompleteChop() {
		state = COOKED;
	}

	@Override
	public int getTimeToChopped() {
		// TODO Auto-generated method stub
		return timeToChopped;
	}

}
