package model.food;

import Utility.ResourseLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Bread extends Ingredient {
	
	public Bread() {
		state = COOKED;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc, double x, double y) {
		// TODO Auto-generated method stub
		
		gc.drawImage(ResourseLoader.bread, x-25, y-60, 50, 50);
	}

}
