package logic;

import shareObject.IRenderable;

public abstract class Entity implements IRenderable {
	protected double x,y;
	protected int z;
	
	protected Entity() {
		super();
	}
	
	public int getZ() {
		return z;
	}
}
