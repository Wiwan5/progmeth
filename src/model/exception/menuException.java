package model.exception;

import model.Menu;

public class menuException extends ArrayIndexOutOfBoundsException {
	private static final long serialVersionUID = 1L;
	Menu m;

	public menuException() {
		// TODO Auto-generated constructor stub
		System.out.println("Menu out of bounds");
	}

}
