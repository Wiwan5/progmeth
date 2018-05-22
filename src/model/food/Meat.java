package model.food;

import Utility.ResourceLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Meat extends Ingredient implements Chopable, Ripenable {
	private int timeToChopped;
	private double timeToRipened;

	public Meat() {
		state = CAN_CHOP;
		timeToChopped = 0;
		timeToRipened = 0;
	}

	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void draw(GraphicsContext gc, double x, double y) {
		// TODO Auto-generated method stub
		if (state == CAN_CHOP) {
			if (timeToChopped >= 65 && timeToChopped <= 70) {
				gc.drawImage(ResourceLoader.meat[7], x - 20, y - 55, 40, 45);
			} else if (timeToChopped >= 55 && timeToChopped < 65) {
				gc.drawImage(ResourceLoader.meat[6], x - 20, y - 55, 40, 45);
			} else if (timeToChopped >= 50 && timeToChopped < 55) {
				gc.drawImage(ResourceLoader.meat[5], x - 20, y - 55, 40, 45);
			} else if (timeToChopped >= 40 && timeToChopped < 50) {
				gc.drawImage(ResourceLoader.meat[4], x - 20, y - 55, 40, 45);
			} else if (timeToChopped >= 30 && timeToChopped < 40) {
				gc.drawImage(ResourceLoader.meat[3], x - 20, y - 55, 40, 45);
			} else if (timeToChopped >= 20 && timeToChopped < 30) {
				gc.drawImage(ResourceLoader.meat[2], x - 20, y - 55, 40, 45);
			} else if (timeToChopped >= 10 && timeToChopped < 20) {
				gc.drawImage(ResourceLoader.meat[1], x - 20, y - 55, 40, 45);
			} else if (timeToChopped >= 0 && timeToChopped < 10) {
				gc.drawImage(ResourceLoader.meat[0], x -20, y - 55, 40, 45);

			}
			if (timeToChopped >= 1) {
				gc.setFill(Color.LIGHTGRAY);
				gc.fillRect(x - 20, y - 40, 30, 5);
				gc.setFill(Color.GREEN);
				gc.fillRect(x - 20, y - 40, (double) (timeToChopped / 7 * 3), 5);
			}
		} else if (state == CAN_RIPEN) {
			if (timeToRipened >= 0 && timeToRipened < 240) {
				gc.drawImage(ResourceLoader.meat[0], x - 20, y - 50, 40, 35);
			} else if (timeToRipened >= 240 && timeToRipened < 600) {
				gc.drawImage(ResourceLoader.meat[8], x - 20, y - 50, 38, 40);
			} else if (timeToRipened >= 600 && timeToRipened <= 720) {
				gc.drawImage(ResourceLoader.meat[9], x - 20, y - 50, 40, 45);
			}

			if (timeToRipened >= 1) {
				gc.setFill(Color.LIGHTGRAY);
				gc.fillRect(x - 20, y - 40, 30, 5);
				gc.setFill(Color.RED);
				gc.fillRect(x - 20, y - 40, (double) (timeToRipened / 72 * 3), 5);
			}
		} else if (state == COOKED) {
			gc.drawImage(ResourceLoader.meat[9], x - 20, y - 60, 40, 45);

		}
	}

	public void setStateWhenCompleteChop() {
		this.state = CAN_RIPEN;
		// this.state = cooked;
	}

	public void setStateWhenCompleteRipen() {
		this.state = COOKED;
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

	@Override
	public void addTimeToRipened() {
		// TODO Auto-generated method stub
		timeToRipened++;
	}

	@Override
	public double getTimeToRippened() {
		return timeToRipened;
	}

}
