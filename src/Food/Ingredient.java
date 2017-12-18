package Food;

public abstract class Ingredient implements Moveable {
	private boolean cancop;
	private boolean canpuff;
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
		cancop = true;
		canpuff =true;
	}
	
	@Override
	public void carry() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void puff() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void wash() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void settle() {
		// TODO Auto-generated method stub
		
	}

}
