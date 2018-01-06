package model.exception;

import model.Menu;

public class menuException extends Exception {
	private static final long serialVersionUID = 1L;
	Menu menu;
	public menuException() {
		// TODO Auto-generated constructor stub
		super();
		menu.generateMenu();
	}
	
	@Override
	public void printStackTrace() {
		System.err.println("menu have only one");
		super.printStackTrace();
	}

}
