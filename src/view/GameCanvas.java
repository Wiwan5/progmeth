package view;



import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import main.Main;

public class GameCanvas extends Canvas{
	private GraphicsContext gc;
	private Font font =Font.font("Time New Roman",FontWeight.BOLD,100);
	
	public GameCanvas() {
		super(Main.weight,Main.height);
		gc = getGraphicsContext2D();
	}
	
	public void time(){
		
	}
	
	
	
	public void start(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, Main.weight, Main.height);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFont(font);
		
		gc.setFill(Color.BEIGE);
		gc.fillText("READY", Main.weight/2-100, Main.height/2-50);
		
		gc.fillText("GO !", Main.weight/2+50,Main.height/2+50);
	}
	
	public void end(GraphicsContext gc) {
		gc.setFill(Color.BISQUE);
		gc.fillRect(0, 0, Main.weight, Main.height);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFont(font);
		
		gc.setFill(Color.CRIMSON);
		gc.fillText("TIME", Main.weight/2-50, Main.height/2-50);
		
		gc.fillText("UP !", Main.weight/2+25, Main.height/2+50);
		
		
	}
}
