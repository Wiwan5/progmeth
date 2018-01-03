package model.food;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Meat extends Ingredient implements Chopable {
	private int timeToChopped;
	
	public Meat() {
		state = canChop;
		timeToChopped = 0;
	}

	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void draw(GraphicsContext gc, double x, double y) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BROWN);
		if (state == canChop) {
			gc.fillRect(x-20, y-30, 30, 20);
			if (timeToChopped >= 1) {
				gc.setFill(Color.LIGHTGRAY);
				gc.fillRect(x-20, y-40, 30, 5);
				gc.setFill(Color.GREEN);
				gc.fillRect(x-20, y-40, (double) (timeToChopped/9), 5);
			}
		} else if (state == canRipen) {
			gc.fillRect(x-20, y-30, 30, 20);
			gc.strokeRect(x-20, y-30, 6, 20);
			gc.strokeRect(x-14, y-30, 6, 20);
			gc.strokeRect(x-8, y-30, 6, 20);
			gc.strokeRect(x-2, y-30, 6, 20);
			gc.strokeRect(x+4, y-30, 6, 20);
		} else if (state == cooked) { 
			gc.setFill(Color.CHOCOLATE);
			gc.fillRect(x-20, y-30, 30, 20);
			gc.strokeRect(x-20, y-30, 6, 20);
			gc.strokeRect(x-14, y-30, 6, 20);
			gc.strokeRect(x-8, y-30, 6, 20);
			gc.strokeRect(x-2, y-30, 6, 20);
			gc.strokeRect(x+4, y-30, 6, 20);
		}
	}
	
	public void setStateWhenCompleteChop() {
		//this.state = canRipen;
		this.state = cooked;
	}
	
	@Override
	public int getTimeToChopped() {
		return timeToChopped;
	}

	@Override
	public void addTimeToChopped() {
		// TODO Auto-generated method stub
		timeToChopped++;
	}
}
