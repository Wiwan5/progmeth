package view;

import javafx.application.Platform;

import Utility.Score;
import game.logic.GameLogic;
import game.ui.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;
import model.GameModel;
import model.player.Player;


public class GamePane extends Pane{
	private static TextField gameOver;
	private static GameModel model = new GameModel();;
	private static GameScreen canvas =new GameScreen(model);
	private static GameLogic logic = new GameLogic(model);
	private static GraphicsContext gc;
	public static Font font =Font.font("Time New Roman",FontWeight.BOLD,70);
//	private AudioClip music = ResourceLoader.game_music;	
	
	public GamePane() {
		super(canvas);
		gc = canvas.getGraphicsContext2D();
		
	}
	
	
	public void start() {
		//music.play();
		//music.setCycleCount(Timeline.INDEFINITE);
		logic.startGame();
		canvas.startAnimation();		
		
		
	}
	
	public void stop() {
		logic.stopGame();
		canvas.stopAnimation();
		gc.setFill(Color.BLACK);
		gc.setFont(font);
		gc.fillText("Game Over", Main.weight/2-300, Main.height/2-20);
		Score.add(Player.name,GameModel.getScore());
		Platform.runLater(() -> {
			Alert alert = new Alert(AlertType.INFORMATION,"Your score :  "+GameModel.getScore(),ButtonType.OK);
			alert.setHeaderText("Cheif  :   "+Player.name);
			alert.setTitle("GameOver");
			alert.showAndWait();
			SceneManager.getCurrent().goTo("menu");
		});		
		
	}

	
	//getter & setter
	public GameScreen getCanvas() {
		return canvas;
	}
}
