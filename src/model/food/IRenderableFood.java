package model.food;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderableFood {
	public abstract int getZ();

	public abstract void draw(GraphicsContext gc, double x, double y);
}
