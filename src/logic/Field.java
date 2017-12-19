package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shareObject.IRenderable;

public class Field implements IRenderable {
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BROWN);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}
	
}
