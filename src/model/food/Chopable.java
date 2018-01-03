package model.food;

public interface Chopable extends IRenderableFood {
	
	public abstract void addTimeToChopped();
	public abstract void setStateWhenCompleteChop();
	public abstract int getTimeToChopped();
}
