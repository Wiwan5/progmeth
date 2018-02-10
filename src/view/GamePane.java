package view;

import javafx.animation.Timeline;
import javafx.application.Platform;
import Utility.ResourseLoader;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;
import model.GameModel;
import model.player.Player;

public class GamePane extends Pane {
	private static GameModel model;
	private static GameScreen canvas = new GameScreen();
	private static GameLogic logic;
	private static GraphicsContext gc = canvas.getGraphicsContext2D();
	public static Font font = Font.font("Time New Roman", FontWeight.BOLD, 100);

	public GamePane() {
		super(canvas);

	}

	public void start() {
		InputUtility.getActiveKeys().clear();
		InputUtility.getTriggerKeys().clear();
		ResourseLoader.gMusic.play(0.5);
		ResourseLoader.gMusic.setCycleCount(Timeline.INDEFINITE);
		model = new GameModel();
		canvas.setGameModel(model);
		logic = new GameLogic(model);

		logic.startGame();
		canvas.startAnimation();

	}

	public void stop() {
		ResourseLoader.gameOver_sound.play(1.5);
		logic.stopGame();
		canvas.stopAnimation();
		Score.add(Player.name, GameModel.getScore());
		ResourseLoader.gMusic.stop();
		Platform.runLater(() -> {
			Alert alert = new Alert(AlertType.INFORMATION, "Your score :  " + GameModel.getScore(), ButtonType.OK);
			alert.setHeaderText("Cheif  :   " + Player.name);
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
