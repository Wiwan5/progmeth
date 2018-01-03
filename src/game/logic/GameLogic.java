package game.logic;

import java.util.ArrayList;
import java.util.List;

import Utility.Score;
import model.field.Field;
import model.food.Plate;
import model.player.Player;
import view.GamePane;
import view.SceneManager;
import model.Entity;
import model.GameModel;
import model.counter.*;

public class GameLogic {
	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private boolean isGameRunning; 
	
	private List<Entity> gameObjectContainer;
	public List<Counter> counterInGame;
	private Player player;
	
	public GameLogic(GameModel model) {
		this.gameObjectContainer = new ArrayList<Entity>();
		this.counterInGame = new ArrayList<>();
		
		this.model = model;
		isGameRunning = false;
		
		Field field = new Field();
		model.getRenderableHolder().add(field);
		player = new Player(300,300,this);
		addNewObject(player);
		/*shelf = new Shelf(105,140,70,70);
		addNewObject(shelf);*/
		addNewObject(new Shelf(105,140,70,70,null));
		addNewObject(new Chest(105,280,70,70));
		addNewObject(new Chopper(105,420,70,70));
		addNewObject(new Shelf(245,140,70,70,new Plate()));
		addNewObject(new Cashier(385,140,70,70,this.model));
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		model.getRenderableHolder().add(entity);
		if (entity!=null && entity instanceof Counter) 	counterInGame.add((Counter) entity);
	}
	
	public void startGame() {
		this.isGameRunning = true;
		new Thread(this::gameLoop, "Game Loop Thread").start();
	}

	public void stopGame() {
		this.isGameRunning = false;
	}

	private void gameLoop() {
		long lastLoopStartTime = System.nanoTime();
		while (isGameRunning) {
			long elapsedTime = System.nanoTime() - lastLoopStartTime;
			if (elapsedTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;

				logicUpdate(elapsedTime);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void logicUpdate(long elapsedTime) {
		player.update();
		model.decreaseRemainingTime(elapsedTime);
		if (model.getTimeNanosecond() <= 0) {
			((GamePane) SceneManager.getCurrent().getPane("game")).stop();
		}
	}
	
}
