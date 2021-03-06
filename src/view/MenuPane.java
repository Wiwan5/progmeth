package view;

import java.util.List;

import Utility.ResourceLoader;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
//import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;

import main.Main;
import menuController.MenuControl;
import menuController.MenuTeb;
import model.player.Player;

public class MenuPane extends AnchorPane {
	private MenuTeb menu;
	private static Canvas mCanvas ;
	private KeyFrame kFrame;
	private Timeline menuLoop;
	private static final Font font = Font.font("Time New Roman", FontWeight.BOLD, 30);
	private static final Font fontInTextField = Font.font("Time New Roman", FontWeight.BOLD, 23);
	private TextField name;
	private AudioClip mMusic = new AudioClip("file:res/sound/mMusic.wav");;

	public MenuPane() {
		super();
		menu = new MenuTeb();
		name = new TextField();
		mCanvas  = new Canvas(Main.width, Main.height);
		GraphicsContext gc = mCanvas.getGraphicsContext2D();
		getChildren().add(mCanvas);
		getChildren().add(name);
		name.setLayoutX(Main.width / 2 - 190);
		name.setLayoutY(430);
		name.setMinSize(400, 60);
		name.setFont(fontInTextField);
		name.setVisible(false);
		name.setAlignment(Pos.CENTER);
		name.setPromptText("Hello,Chef ..TYPE YOUR NAME..");
		kFrame = new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				draw(gc);
				if (menu.getState() == 0) {

					name.setVisible(true);
					drawMenu(gc);

				}
				if (menu.getState() == 1) {
					name.setVisible(false);
					drawMenu(gc);
				}
			}
		});

	}

	public void start() {
		mMusic.setCycleCount(AudioClip.INDEFINITE);
		mMusic.play();
		menuLoop = new Timeline();
		menuLoop.setCycleCount(Timeline.INDEFINITE);
		menuLoop.getKeyFrames().add(kFrame);
		menuLoop.play();
	}

	public void stop() {
		menuLoop.stop();
		mMusic.stop();
	}

	// DRAW CANVAS

	public void drawMenu(GraphicsContext gc) {
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		try {
			List<String> m = menu.getMenu();
			for (int i = 0; i < m.size(); i++) {
				if (m.get(i).equals(""))
					continue;
				gc.setFill(Color.BROWN);
				if (i == menu.getSelect())
					gc.setFill(Color.CHOCOLATE);
				gc.fillRoundRect(Main.width / 2 - 100, 450 + i * 80, 200, 50, 10, 10);
				
				gc.setFont(font);
				if (i == menu.getSelect())
					gc.setFill(Color.BEIGE);
				else
					gc.setFill(Color.BURLYWOOD);
				gc.fillText((String) m.get(i), Main.width / 2, 470 + i * 80);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(GraphicsContext gc) {
		gc.drawImage(ResourceLoader.bg0, 0, 0,Main.width,Main.height);
		gc.drawImage(ResourceLoader.logo, Main.width / 2 - 300, 100);
	}

	// getter
	public String getName() {
		return name.getText().trim();
	}

	public MenuTeb getMenu() {
		return menu;
	}

	public Canvas getMenuCanvas() {
		return mCanvas;
	}
}