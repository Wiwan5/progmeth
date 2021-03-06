package model.counter;

import Utility.ResourceLoader;
import javafx.scene.canvas.GraphicsContext;
import model.food.IRenderableFood;
import model.food.Plate;

public class Garbage extends Counter {

	public Garbage(double x, double y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean counterHaveFood() {
		return false;
	};

	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (!(foodOnPlayer instanceof Plate))
			return true;
		Plate plate = (Plate) foodOnPlayer;
		if (!plate.plateHaveFood())
			return false;
		return true;

	}

	@Override
	public IRenderableFood setFoodOnCounter(IRenderableFood food) {
		if (food instanceof Plate) {
			Plate plate = (Plate) food;
			plate.dumpFood();
			return plate;
		}
		return null;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(ResourceLoader.counter[9], x - width / 2, y - height, width, height);

		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}
