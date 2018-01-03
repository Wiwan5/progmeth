package model;

public abstract class Entity implements IRenderable {
	protected double x,y;
	protected int z, width, height;
	
	protected Entity() {
		super();
	}
	
	public int getZ() {
		return z;
	}
}
