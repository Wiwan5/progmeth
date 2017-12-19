package logic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Player extends Entity{
	
	private static final int speed = 5;
	protected int width;
	protected int height;
	private int scope;
	
	public Player(double x, double y) {
		this.x = x;
		this.y = y;
//-----------------------------------------
//find from player picture
		this.width = 40;
		this.height = 40;
//-----------------------------------------
		this.scope = width*2/3;
	}
	
	/*public boolean inScope(double Xlocation ,double Ylocation) {
		if ()
	}*/
	
	private void right() {
		if (x < 900 - width/2)
			this.x += speed;
	}
	
	private void left() {
		if (x > width/2)
		this.x -= speed;
	}
	
	private void up() {
		if (y > height)
		this.y -= speed;
	}
	
	private void down() {
		if (y < 600)
		this.y += speed;
	}
	
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.RIGHT)) {
			right();
		}
		if (InputUtility.getKeyPressed(KeyCode.LEFT)) {
			left();
		}
		if (InputUtility.getKeyPressed(KeyCode.UP)) {
			up();
		}
		if (InputUtility.getKeyPressed(KeyCode.DOWN)) {
			down();
		}
		//System.out.println(x+" "+y);
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLUE);
		System.out.println(x+" "+y);
		//gc.fillArc(x-radius, y-radius, radius*2, radius*2, 0, 360, ArcType.OPEN);
		gc.fillRect(x - width/2, y - height, width, height);
		gc.setFill(Color.BLACK);
		gc.strokeRect(x - width/2, y-height-scope, width, scope*2 + height);
		gc.strokeRect(x - width/2-scope, y-height, scope*2 + width, height);
	}
	
	public int getZ() {
		return 0;
	}
}
