package model.field;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IRenderable;

public class Field implements IRenderable {

	private int[][] field;
	private int row;
	private int col;

	// ------------------------------------------------
	public Field() {
		field = new int[][] {{1,1,1,20,21,22,1,1,1,1,1,1,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,1},
							//{1,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,1,0,0,1,1,1,1,0,0,1},
							{1,0,0,0,0,0,0,0,0,0,0,0,6},
							{1,0,0,0,0,0,0,0,0,0,0,0,1},
							{4,0,0,0,0,0,0,0,0,0,0,0,1},
							{1,1,1,3,1,3,1,5,1,9,9,1,1}};
							
		row = field.length;
		col = field[0].length;
	}
	//------------------modify in next time--------------------

	public int getZ() {
		return -9999;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int[][] getField() {
		return field;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.CYAN);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		
		
		
	}

}
