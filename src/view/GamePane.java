package view;

import javafx.animation.Timeline;
import javafx.application.Platform;
import Utility.ResourceLoader;
import Utility.Score;
import game.logic.GameLogic;
import game.ui.GameScreen;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;
import model.GameModel;
import model.player.Player;

public class GamePane extends Pane {
	private static GameModel model;
	private static GameScreen canvas ;
	private static GameLogic logic;
	private static GraphicsContext gc;
	public static Font font = Font.font("Time New Roman", FontWeight.BOLD, 100);
	private static AudioClip gMusic = new AudioClip("file:res/sound/gMusic.wav");

	public GamePane() {
		super();
		canvas = new GameScreen();
		gc = canvas.getGraphicsContext2D();
		getChildren().add(canvas);
	}

	public void start() {
		InputUtility.getActiveKeys().clear();
		InputUtility.getTriggerKeys().clear();
		gMusic.setCycleCount(AudioClip.INDEFINITE);
		gMusic.play(0.5);
		model = new GameModel();
		canvas.setGameModel(model);
		logic = new GameLogic(model);

		logic.startGame();
		canvas.startAnimation();

	}

	public void stop() {
		ResourceLoader.gameOver_sound.play(1.5);
		logic.stopGame();
		canvas.stopAnimation();
		Score.add(Player.getName(), GameModel.getScore());
		gMusic.stop();
		Platform.runLater(() -> {
			Alert alert = new Alert(AlertType.INFORMATION, "Your score :  " + GameModel.getScore(), ButtonType.OK);
			alert.setHeaderText("Chef  :   " + Player.getName());
			alert.setTitle("GameOver");
			alert.showAndWait();
			SceneManager.getCurrent().goTo("menu");
		});

	}

	// getter & setter
	public GameScreen getCanvas() {
		return canvas;
	}

	public GameModel getGameModel() {
		return model;
	}

}
