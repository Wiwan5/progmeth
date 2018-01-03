package model.food;

public abstract class Ingredient implements IRenderableFood {
	public static final int canChop = 1;
	public static final int canRipen = 2;
	public static final int cooked = 3;
	
	protected int state;
	
	public int getState() {
		return state;
	}
}