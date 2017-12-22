package view;

import javafx.stage.Stage;


import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.Parent;
import javafx.scene.Scene;


public class SceneManager {
	private Stage stage;
	private static SceneManager crrS= null;
	
	private ConcurrentHashMap<String, Scene>	mScene = new ConcurrentHashMap<>();
	private ConcurrentHashMap<String, Parent>	mPane =new ConcurrentHashMap<>();
	
	public SceneManager(Stage stage) {
		this.stage =stage;
		crrS = this;
		mPane.put("game", new GamePane());
		mPane.put("menu", new MenuPane());
		mScene.put("game", new Scene(mPane.get("game")));
		mScene.put("menu", new Scene(mPane.get("menu")));
		
	}
	
	
	 public void goTo(String key) {
		 stage.setScene(mScene.get(key));
		 mPane.get(key).requestFocus();
		 if(mPane.get(key) instanceof GamePane) {
			 ((GamePane) mPane.get(key)).getCanvas().requestFocus();
		 }
		 if(mPane.get(key) instanceof MenuPane) {
			 ((MenuPane) mPane.get(key)).start();
			 ((MenuPane) mPane.get(key)).getMenuCanvas().requestFocus();
			  
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
			return (SceneManager) crrS;
		}
	

}
