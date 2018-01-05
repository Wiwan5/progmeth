package model.food;

public abstract class Ingredient implements IRenderableFood {
	public static final int CAN_CHOP = 1;
	public static final int CAN_RIPEN = 2;
	public static final int COOKED = 3;
	
	protected int state;
	
	public int getState() {
		return state;
	}
}