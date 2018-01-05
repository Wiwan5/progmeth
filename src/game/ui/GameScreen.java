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

	private static final Font TEXT_FONT = new Font("Monospace", 80);
	private static final Font SCORE_TIME_FONT = new Font("Monospace", 30);

	private GraphicsContext gc;

	private GameModel model;
	private Thread gameAnimation;
	private boolean isAnimationRunning;

	public GameScreen() {
		this.setWidth(Main.weight);
		this.setHeight(Main.height);

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
		gc.setFill(Color.BLACK);
		gc.setFont(SCORE_TIME_FONT);
		gc.fillText("Time: " + model.getTimeSecond(),
				Main.weight -150,50);
		gc.fillText("Score: " + GameModel.getScore(), Main.weight - 150, Main.height -50);
		
		
		updateMenu(gc);
		
	}

	public void updateMenu(GraphicsContext gc) {
			int ch = 0;
			boolean remove = false;
			
			for(Pair<Food,Time> menu : model.currentMenu) {
				if(menu.second.isTimeup())	remove = true;
					
					//System.out.println("ch");
					draw(Menu.position.get(ch),menu,gc);
					drawTime(Menu.position.get(ch),menu,gc);
					ch++;
			
			}
			if(remove)	{
				for(Pair<Food,Time> menu : model.currentMenu) {
					if(menu.second.isTimeup())	{
						model.currentMenu.remove(menu);
						model.add();
					}
						
				}
			}
			
			
		}

	private void draw(Pair<Double, Double> pos, Pair<Food, Time> menu,GraphicsContext gc) {
		// TODO Auto-generated method stub
		double x = pos.first;
		double y = pos.second;
		gc.setFill(Color.HONEYDEW);
		gc.fillRect(x + 10, y, 150, 120);
		// gc.drawImage(ResourseLoader.bread, x+60, y+100,15,15);

		if (menu.first.getIngredient(0) == true) {
			// gc.drawImage(ResourseLoader.meat,x+80,y+100,15,15);
			
		}
		if (menu.first.getIngredient(1) == true) {
			// gc.drawImage(ResourseLoader.veg,x+100, y+100,15,15);
		}
	}

	public void drawTime(Pair<Double, Double> pos, Pair<Food, Time> menu,GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.web("#122335"));
		gc.fillRect(pos.first + 10, pos.second + 10, 150, 20);
		gc.setFill(Color.web("#7EB19E"));
		gc.fillRect(pos.first + 10, pos.second + 10,
				(menu.second.getReduce() ) <= 0 ? 0.01 : menu.second.getReduce(), 20);

	}
	
	
	
	public void setGameModel(GameModel model) {
		this.model = model;
	}

}
