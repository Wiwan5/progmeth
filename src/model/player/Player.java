package model.player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import main.Main;
import model.Entity;
import model.counter.Chopper;
import model.counter.Counter;
import model.food.IRenderableFood;
import model.food.Plate;
import Utility.ResourseLoader;
import game.logic.GameLogic;
import input.InputUtility;

public class Player extends Entity {
	public static String name = "";
	private static final int RIGHT = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;
	private static final int DOWN = 4;

	private static final int speed = 4;
	private static boolean isChop = false;
	private int scope;
	private GameLogic logic;
	private int direction;
	protected IRenderableFood foodOnPlayer;
	// protected List<Shelf> counterInScope;

	public Player(double x, double y, GameLogic logic) {
		// counterInScope = new ArrayList<>();
		this.x = x;
		this.y = y;
		// -----------------------------------------
		// find from player picture
		this.width = 40;
		this.height = 40;
		// -----------------------------------------
		this.scope = width * 1 / 3;

		this.logic = logic;
		this.foodOnPlayer = null;
		direction = DOWN;
	}

	public boolean frontHaveObject(double otherX, double otherY, int otherW, int otherH, int changeX, int changeY) {
		double x1, x2, y1, y2;
		x1 = x - width / 2 + changeX;
		x2 = otherX - otherW / 2;
		y1 = y - height + changeY;
		y2 = otherY - otherH;

		if ((x1 + width > x2 && x2 + otherW > x1) && (y1 + height > y2 && y2 + otherH > y1)) {
			return true;
		}
		return false;
	}

	/*
	 * public boolean inScopeX(double xEntity , int wEntity) { if (x+width > xEntity
	 * && xEntity+wEntity > x) return true; return false; } public boolean
	 * inScopeY(double yEntity,int hEntity) { if (y+height > yEntity &&
	 * yEntity+hEntity>y) return true; return false; }
	 */

	private Counter checkFrontObject() {
		int frontX = 0, frontY = 0;
		if (direction == LEFT)
			frontX = -scope;
		else if (direction == RIGHT)
			frontX = scope;
		else if (direction == UP)
			frontY = -scope;
		else if (direction == DOWN)
			frontY = scope;
		for (Counter c : logic.counterInGame) {
			if (frontHaveObject(c.getX(), c.getY(), c.getWidth(), c.getHeight(), frontX, frontY)) {
				double x1, x2, y1, y2;
				if (direction == LEFT || direction == RIGHT) {
					y1 = y - height;
					y2 = c.getY() - c.getHeight();
					if ((y1 >= y2 && y2 + c.getHeight() - y1 >= height / 2)
							|| (y1 < y2 && y1 + height - y2 >= height / 2))
						return c;
				} else if (direction == UP || direction == DOWN) {
					x1 = x - width / 2;
					x2 = c.getX() - c.getWidth() / 2;
					if ((x1 >= x2 && x2 + c.getWidth() - x1 >= width / 2) || (x1 < x2 && x1 + width - x2 >= width / 2))
						return c;
				}
			}
		}
		return null;
	}

	private void settleFood(Counter counter) {
		if (counter == null || !counter.canSettle(foodOnPlayer))
			return;
		foodOnPlayer = counter.setFoodOnCounter(foodOnPlayer);
	}

	/*
	 * private void callIngredient(Counter counter) { if (counter != null &&
	 * counter.counterHaveFood()) foodOnPlayer = counter.callIngredient(this); }
	 */

	// for check run process
	private void callIngredient(Counter counter) {
		if (counter != null) {
			if (counter.counterHaveFood()) {
				foodOnPlayer = counter.callIngredient(this);
				System.out.println("sucess for call ingredient");
			} else
				System.out.println("counter not have food");
		} else
			System.out.println("In front of not have counter for use");
	}

	/*
	 * private void chopping(Counter counter) { if (counter instanceof Chopper &&
	 * counter.getFoodOnShelf() != null) { ((Chopper) counter).chopping(); return; }
	 * System.out.println("Can't chopping"); }
	 */

	private void chopping(Counter counter) {
		if (counter instanceof Chopper) {
			if (counter.counterHaveFood()) {
				((Chopper) counter).chopping();
				isChop = true;
				return;
			} else {
				System.out.println("no food can chopping");
				isChop = false;
			}

		} else {
			System.out.println("It's not Chopper");
			isChop = false;
		}
	}

	private boolean canWalk(int changeX, int changeY) {
		for (Counter c : logic.counterInGame) {
			if (frontHaveObject(c.getX(), c.getY(), c.getWidth(), c.getHeight(), changeX, changeY))
				return false;
		}
		return true;
	}

	private void right() {
		direction = RIGHT;
		if (canWalk(speed, 0) && x < Main.weight - width / 2)
			this.x += speed;
	}

	private void left() {
		direction = LEFT;
		if (canWalk(-speed, 0) && x > width / 2)
			this.x -= speed;
	}

	private void up() {
		direction = UP;
		if (canWalk(0, -speed) && y > height)
			this.y -= speed;
	}

	private void down() {
		direction = DOWN;
		if (canWalk(0, speed) && y < Main.height)
			this.y += speed;
	}

	public void update() {
		Counter counter = checkFrontObject();

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

		if (InputUtility.getKeyPressed(KeyCode.S)) {
			chopping(counter);
		}
		while (InputUtility.isPollAvailable()) {
			KeyCode key = InputUtility.pollKey();

			if (key == KeyCode.A) {
				if (foodOnPlayer == null) {
					callIngredient(counter);
				} else {
					settleFood(counter);
				}
			}
			// -----------------------for develop-------------------------
			else if (key == KeyCode.F) {
				foodOnPlayer = null;
			} else if (key == KeyCode.P) {
				foodOnPlayer = new Plate();
			}
		}
		// -----------------------------------------------------------
	}

	public void draw(GraphicsContext gc) {

		gc.drawImage(ResourseLoader.player1.get(direction), x - width / 2 - 25, y - height - 30, 90, 90);
		/*
		 * gc.setFill(Color.BLACK); gc.strokeRect(x - width / 2, y - height - scope,
		 * width, scope * 2 + height); gc.strokeRect(x - width / 2 - scope, y - height,
		 * scope * 2 + width, height);
		 */
		gc.drawImage(ResourseLoader.effChop, x - width / 2 - 25, y - height - 30, 100, 100);
		if (foodOnPlayer != null) {
			foodOnPlayer.draw(gc, x - 1, y - 30);
		}
	}

	public int getZ() {
		return 9;
	}

}
