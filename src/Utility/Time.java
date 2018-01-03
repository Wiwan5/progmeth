package Utility;

public class Time {
	private static double start;
	private static double t ;
	private static boolean pause;
	
	public Time(long tm){
		t = tm;	//tm in each thing or checkpoint unit ms
		start = 0;
		pause = false;
	}
	public static void start() {
		start = 0;
		start = System.currentTimeMillis();		
	}
	
	public static  void pause(double c) {	//c is current time that send from the game
		pause = true;
		setT(getT()-c);		
	}
	public static double getReduce() {
		return t-start;
	}
	
	public static boolean isTimeup() {
		return t-start <= 0;
	}
	
	public static String printTime() {
		double i = t-start;
		int g= (int) i/1000;
		int mins = g/60;
		g = g-(mins)*60;
		return Integer.toString(mins) +":"+Integer.toString(g);
	}
	
	
	//getter && setter
	public static double getStart() {
		return start;
	}


	public static void setStart(long start) {
		Time.start = start;
	}


	public static double getT() {
		return t;
	}

	public static void setT(double t) {
		Time.t = t;
	}
	
	
	

	
	
	

}
