package controller;

public class Time {
	private static long start;
	private static long t ;
	
	Time(long tm){
		t = tm;	//tm in each thing or checkpoint unit ms
		start();
	}
	public static void start() {
		start = System.currentTimeMillis();		
	}
	
	public static void pause(long c) {	//c is current time that send from the game 
		setT(getT()-c);
	}
	
	public static boolean isTimeup(long c) {
		return c-start >= t;
	}
	
	
	//getter && setter
	public static long getStart() {
		return start;
	}


	public static void setStart(long start) {
		Time.start = start;
	}


	public static long getT() {
		return t;
	}

	public static void setT(long t) {
		Time.t = t;
	}
	
	
	

	
	
	

}
