package logic;

import java.util.ArrayList;
import java.util.List;

import shareObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private Player player;
	
	public GameLogic() {
		this.gameObjectContainer = new ArrayList<Entity>();
		
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		player = new Player(300,300);
		addNewObject(player);
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate() {
		player.update();
	}
	
}
