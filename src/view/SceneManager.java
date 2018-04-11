package view;

import javafx.stage.Stage;

import java.util.HashMap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.Pane;

public class SceneManager {
	private Stage stage;
	private static SceneManager currentStage = null;

	private HashMap<String, Scene> mScene = new HashMap<>();
	private HashMap<String, Pane> mPane = new HashMap<>();

	public SceneManager(Stage stage) {
		this.stage = stage;
		currentStage = this;
		mPane.put("game", new GamePane());
		mPane.put("menu", new MenuPane());
		mScene.put("game", new Scene(mPane.get("game")));
		mScene.put("menu", new Scene(mPane.get("menu")));

	}

	public void goTo(String key) {
		stage.setScene(mScene.get(key));
		mPane.get(key).requestFocus();
		if (mPane.get(key) instanceof GamePane) {
			((GamePane) mPane.get(key)).getCanvas().requestFocus();

		}
		if (mPane.get(key) instanceof MenuPane) {
		//	((MenuPane) mPane.get(key)).getMenuCanvas().requestFocus();
			((MenuPane) mPane.get(key)).start();

		}
	}

	public Scene getScene(String key) {
		return mScene.get(key);
	}

	public Parent getPane(String key) {
		return mPane.get(key);
	}

	public Stage getState() {
		return stage;
	}

	public static SceneManager getCurrent() {
		return currentStage;
	}

}