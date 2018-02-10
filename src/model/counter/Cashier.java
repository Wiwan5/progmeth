package model.counter;

import Utility.ResourseLoader;
import javafx.scene.canvas.GraphicsContext;
import model.GameModel;
import model.food.IRenderableFood;
import model.food.Plate;

public class Cashier extends Counter {

	private GameModel model;

	public Cashier(double x, double y, int w, int h, GameModel model) {
		super(x, y, w, h);
		this.model = model;
	}

	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (foodOnPlayer instanceof Plate) {
			Plate plate = (Plate) foodOnPlayer;
			return plate.plateHaveFood();
		}
		return false;
	}

	@Override
	public IRenderableFood setFoodOnCounter(IRenderableFood food) {
		Plate plate = (Plate) food;
		model.serve(plate.getFoodOnPlate());
		// foodOnCounter = new Plate();
		plate.dumpFood();
		return plate;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

		gc.drawImage(ResourseLoader.counter[8], x - width / 2 - 20, y - height, width + 20, height);

		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}
