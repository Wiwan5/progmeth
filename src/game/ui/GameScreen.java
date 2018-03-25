package game.ui;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Main;
import model.GameModel;
import model.IRenderable;

import model.Menu;
import model.counter.Stove;
import model.exception.MenuException;

public class GameScreen extends Canvas {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private static final Font SCORE_TIME_FONT = new Font("Monospace", 40);
	private static final Font DEADLINE = new Font("Monospace", 50);

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
		Stove.setMusic(false);
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
		// GraphicsContext gc = this.getGraphicsContext2D();
		try {

			for (IRenderable entity : model.getEntities()) {
				entity.draw(gc);

			}

			if (model.getTimeSecond() < 10) {
				gc.setFont(DEADLINE);
				gc.setFill(Color.web("#dab41b"));
				gc.fillText("" + model.getTimeSecond(), Main.weight - 100, 79);
				gc.setFill(Color.RED);
				gc.fillText("" + model.getTimeSecond(), Main.weight - 105, 76);
			} else {
				gc.setFont(SCORE_TIME_FONT);
				gc.setFill(Color.web("#dab41b"));
				gc.fillText("" + model.getTimeSecond(), Main.weight - 100, 77);
				gc.setFill(Color.web("#716658"));
				gc.fillText("" + model.getTimeSecond(), Main.weight - 105, 74);
			}

			gc.setFont(SCORE_TIME_FONT);
			gc.setFill(Color.web("#b682b2"));
			gc.fillText("" + GameModel.getScore(), Main.weight - 80, Main.height - 57);
			gc.setFill(Color.web("#716658"));
			gc.fillText("" + GameModel.getScore(), Main.weight - 83, Main.height - 60);

			menu.updateMenu(gc);

		} catch (MenuException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void setGameModel(GameModel model) {
		this.model = model;
	}

}
