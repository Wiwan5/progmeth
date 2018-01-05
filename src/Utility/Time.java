package Utility;

import model.GameModel;
import view.GamePane;
import view.SceneManager;
public class Time {
	private long start;
	private int t ;
	//private static GameModel model = ((GamePane) SceneManager.getCurrent().getPane("game")).getGameModel();
	
	public Time(int tm){
		t = tm;	//tm in each thing or checkpoint unit ms
		start = System.currentTimeMillis();
		
	}
	
	/*
	public  void pause(double c) {	//c is current time that send from the game
		pause = true;
		setT(getT()-c);		
	}
	*/
	public long getReduce() {
		return (t-( System.currentTimeMillis()-start))*150/t;
	}
	
	public boolean isTimeup() {
		return System.currentTimeMillis()-start>= t;
	}
	
	
	//getter && setter
	public double getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public double getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}
	
	
	

	
	
	

}
