package model.counter;

import Utility.ResourseLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.GameModel;
import model.food.IRenderableFood;
import model.food.Plate;
import model.player.Player;

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
		//foodOnCounter = new Plate();
		plate.dumpFood();
		return plate;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		gc.drawImage(ResourseLoader.counter[8], x-width/2 - 10, y-height, width, height);
		
		
		
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}
