package model.food;

public interface Chopable extends IRenderableFood {
	public static final int TIMEFORCOMPLETECHOPPED = 70;

	public abstract void addTimeToChopped();

	public abstract void setStateWhenCompleteChop();

	public abstract int getTimeToChopped();
}
