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

import model.Menu;
import model.counter.Stove;
import model.exception.MenuException;

public class GameScreen extends Canvas {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private static final Font SCORE_TIME_FONT = new Font("Monospace", 40);
	private static final Font DEADLINE = new Font("Monospace", 50);
	private static final Font SCORE_EFFECT= new Font("Monospace", 25);

	private GraphicsContext gc;
	private Menu menu;
	private GameModel model;
	private Thread gameAnimation;
	private boolean isAnimationRunning;
	private Pair<Integer,Integer> score;
	private int scoreEffect;

	public GameScreen() {
		this.setWidth(Main.width);
		this.setHeight(Main.height);
		menu = new Menu();
		isAnimationRunning = false;
		gc = this.getGraphicsContext2D();
		// this.setVisible(true);
		scoreEffect = 0;
		score = Pair.make_pair(0, 0);
		addListerner();
	}

	public void startAnimation() {
		this.requestFocus();
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
		Stove.setSound(false);
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
				gc.fillText("" + model.getTimeSecond(), Main.width - 90, 75);
				gc.setFill(Color.RED);
				gc.fillText("" + model.getTimeSecond(), Main.width - 95, 72);
			} else {
				gc.setFont(SCORE_TIME_FONT);
				gc.setFill(Color.web("#dab41b"));
				gc.fillText("" + model.getTimeSecond(), Main.width - 98, 70);
				gc.setFill(Color.web("#716658"));
				gc.fillText("" + model.getTimeSecond(), Main.width - 102, 66);
			}
			
			
			if(model.getScore() != score.first) {
				//gc.fillText("+"+, x, y);
				score.second = model.getScore() - score.first;
				scoreEffect = 10;
				score.first = model.getScore();
			}
			if(scoreEffect > 0 && score.second != 0) {
				System.out.println(scoreEffect);	
				gc.setFont(SCORE_EFFECT);
				gc.setFill(Color.BROWN);
				gc.fillText("+"+score.second,Main.width -80, Main.height -80-2*scoreEffect);
			}
			gc.setFont(SCORE_TIME_FONT);
			gc.setFill(Color.web("#b682b2"));
			gc.fillText("" + score.first, Main.width - 84, Main.height - 52);
			gc.setFill(Color.web("#716658"));
			gc.fillText("" + score.first, Main.width - 88, Main.height - 55);
			scoreEffect--;
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
