package model.field;

import Utility.ResoureLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IRenderable;

public class Field implements IRenderable {

	private int[][] field;
	private int row;
	private int col;

	// ------------------------------------------------
	public Field() {
		field = new int[][] {{11,12,12,20,21,22,12,12,12,12,12,12,11},
									{11,0,0,0,0,0,0,0,0,0,0,0,11},
										{11,0,0,0,0,0,0,0,0,0,0,0,11},
										//{1,0,0,0,0,0,0,0,0,0,0,0,1},
										{11,12,12,12,0,0,12,12,12,12,0,0,11},
										{11,0,0,0,0,0,0,0,0,0,0,0,6},
										{11,0,0,0,0,0,0,0,0,0,0,0,11},
										{4,0,0,0,0,0,0,0,0,0,0,0,11},
										{11,11,11,3,11,3,11,5,11,9,9,11,11}};
							
		row = field.length;
		col = field[0].length;
	}
	//------------------modify in next time--------------------

	public int getZ() {
		return -9999999;
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
		
		gc.drawImage(ResoureLoader.bg1,0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		
		
		
	}

}
