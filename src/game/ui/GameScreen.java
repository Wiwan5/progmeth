package game.ui;



import Utility.Pair;

import Utility.Time;
import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Main;
import model.GameModel;
import model.IRenderable;
import model.food.Food;

import model.Menu;

public class GameScreen extends Canvas {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private static final Font SCORE_TIME_FONT = new Font("Monospace", 40);

	private GraphicsContext gc;
	Menu menu;
	private GameModel model;
	private Thread gameAnimation;
	private boolean isAnimationRunning;

	public GameScreen() {
		this.setWidth(Main.weight);
		this.setHeight(Main.height);
		menu = new Menu();
		isAnimationRunning = false;
		gc = this.getGraphicsContext2D();

		// this.setVisible(true);
		gc.setFont(SCORE_TIME_FONT);
		
		addListerner();
	}

	public void startAnimation() {
		gameAnimation = new Thread(this::animationLoop, "Game Animation Thread");
		isAnimationRunning = true;
		gameAnimation.start();
	}

	public void stopAnimation() {
		isAnimationRunning = false;

	}

	private void animationLoop() {
		long lastLoopStartTime = System.nanoTime();
		while (isAnimationRunning) {
			long now = System.nanoTime();
			if (now - lastLoopStartTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;

				updateAnimation(now);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});
		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

	public void updateAnimation(long now) {
		//GraphicsContext gc = this.getGraphicsContext2D();
		
		for (IRenderable entity : model.getEntities()) {
			entity.draw(gc);
		
		}

		gc.setFill(Color.web("#dab41b"));
		gc.fillText(""+model.getTimeSecond(), Main.weight-109, 77);
		gc.setFill(Color.web("#b682b2"));
		gc.fillText(""+GameModel.getScore(), Main.weight-95, Main.height-65);
		gc.setFill(Color.web("#716658"));
		gc.fillText(""+model.getTimeSecond(), Main.weight-112, 74);
		gc.fillText(""+GameModel.getScore(), Main.weight-98, Main.height-68);
		
		
		menu.updateMenu(gc);
		
	}

	

	
	
	
	public void setGameModel(GameModel model) {
		this.model = model;
	}

}
