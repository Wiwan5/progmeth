package shareObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import logic.Field;
import logic.Player;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ()) return 1;
			return -1;
		};
	}
	
	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities,comparator);
		for (IRenderable x: entities) {
			if (x instanceof Player) System.out.println("player");
			if(x instanceof Field) System.out.println("field");
		}
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	
	public void update() {
		/*for (int i= entities.size() - 1; i>=0; i--) {
			
		}*/
	}
	
	public List<IRenderable> getEntities() {
		return entities;
	}
}
