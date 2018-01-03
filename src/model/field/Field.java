package model.field;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IRenderable;

public class Field implements IRenderable {

	private static int[][] field = new int[13][8];

	// ------------------------------------------------
	public Field() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 8; j++) {
				field[i][j] = 0;
				if (i == 2 && j == 2)
					field[i][j] = 1;
			}
		}
	}
	//------------------modify in next time--------------------

	public int getZ() {
		return -9999;
	}
	
	public static int[][] getField() {
		return field;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.CYAN);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		gc.setFill(Color.LIGHTGRAY);
		int size = 70;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 8; j++) {
				gc.strokeRect(i*size, j*size, size, size);
			}
		}
		
	}

}
