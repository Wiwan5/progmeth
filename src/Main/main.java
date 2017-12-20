package Main;
import draw.GameScreen;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import shareObject.RenderableHolder;

public class main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		//public static final int width = 900; create class to control canvas
		//public static final int height = 600;
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("TOU cooking game");

		GameLogic logic = new GameLogic();
		GameScreen gameScreen = new GameScreen(1200, 800);
		root.getChildren().add(gameScreen);
		gameScreen.requestFocus();
		
		stage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				//InputUtility.updateInputState();
			}
		};
		animation.start();
		
	}
}