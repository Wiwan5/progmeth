package model.exception;



public class menuException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public menuException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public void printStackTrace() {
		System.out.println("menu have only one");
		super.printStackTrace();
	}

}
