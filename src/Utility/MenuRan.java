package Utility;


import java.util.Random;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import view.GamePane;
import view.SceneManager;

public class MenuRan implements Comparable<MenuRan>{
	
	public Menu menu;
	private Canvas gameCanvas;
	private GraphicsContext gc;
	private Pair<Double,Double> st = new Pair<>();
	private Pair<Double,Double> pos =new Pair<>();
	private int n;
	private Time time;
	private boolean isFin;
	
	public MenuRan(Pair<Double,Double> start,Canvas gameCanvas){
		this.gameCanvas = gameCanvas;
		menu = new Menu();
		st.make_pair(start.first, start.second);
		time =new Time(45000);
		pos.make_pair(start.first+160,start.second);
		gc = gameCanvas.getGraphicsContext2D();
		Random rand = new Random();
		n = rand.nextInt(3) + 1;
		isFin = false;
		
	}
	public void pause(double c) {
		time.pause(c);
	}
	
	
	public void start() {
		draw(st,gc);
		drawTime(st, gc);
		time.start();
	}
	public void update(Pair<Double,Double> position) {
		draw(position,gc);
		drawTime(position, gc);
		if(!isFin)	isFin = time.isTimeup();
	}


	public void drawTime(Pair<Double,Double> pos,GraphicsContext gc) {
		gc.setFill(Color.web("#122335"));
		gc.fillRect(pos.first+10, pos.second+10,150, 20);
		gc.setFill(Color.web("#7EB19E"));
		gc.fillRect(pos.first+10, pos.second+10,time.getReduce()*0.02<0?0:time.getReduce()*0.02, 20);
	}
	public void draw(Pair<Double,Double> pos,GraphicsContext gc) {
		gc.setFill(Color.HONEYDEW);
		gc.fillRoundRect(pos.first+10, pos.second, 150, 120, 10, 10);
		//gc.drawImage(, x, y);
		if(this.n==1) {
			gc.drawImage(menu.get("bread"), pos.first+55, pos.second+95, 15, 15);
			gc.drawImage(menu.get("veg"), pos.first+80, pos.second+95,15,15);
		}
		else if(this.n==2) {
			gc.drawImage(menu.get("bread"), pos.first+55, pos.second+95, 15, 15);
			gc.drawImage(menu.get("meat"), pos.first+80, pos.second+95,15,15);
		}
		else if(this.n==3) {
			gc.drawImage(menu.get("bread"), pos.first+40, pos.second+95, 15, 15);
			gc.drawImage(menu.get("veg"), pos.first+75, pos.second+95,15,15);
			gc.drawImage(menu.get("bread"), pos.first+100, pos.second+95, 15, 15);
			
		}
		
	}
	public Time getTime() {
		return time;
	}
	
	public boolean isFinish() {
		return isFin;
	}
	
	
	
	
	public void setStart(Pair<Double,Double> s) {
		this.st = s;
	}

	@Override
	public int compareTo(MenuRan o) {
		// TODO Auto-generated method stub
		return Double.compare(o.getTime().getReduce(),getTime().getReduce());
	}

}
