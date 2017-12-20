package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class St extends Application {
	
	public static int SCREEN_WIDTH = 1200;
	public static int SCREEN_HEIGHT = 900;
	public static int state = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		TextField text = new TextField("NAME");
		text.setPrefSize(250, 20);
		Button btn1 = new Button("Start Game");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				state = 1;
				System.out.println("Hello World");
			}
		});
		Button btn2 = new Button("Score Board");
		Button btn3 = new Button("Exit");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				primaryStage.close();
				
			}
		});
		VBox root1 = new VBox(20);

		root1.getChildren().addAll(text,btn1,btn2,btn3);
		
		StackPane b1 = new StackPane();
		b1.getChildren().add(root1);
		Scene scene = new Scene(b1, SCREEN_WIDTH, SCREEN_HEIGHT);
		primaryStage.setTitle("TOU cooking game"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
