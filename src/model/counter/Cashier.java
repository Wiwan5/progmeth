package model.counter;

import javafx.scene.canvas.GraphicsContext;
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
	public void setFoodOnCounter(IRenderableFood food) {
		Plate plate = (Plate) food;
		model.serve(plate.getFoodOnPlate());
		foodOnCounter = new Plate();
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.PLUM);
		gc.fillRect(x-width/2, y-height, width, height);
		
		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}
