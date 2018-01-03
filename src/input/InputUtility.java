package input;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import javafx.scene.input.KeyCode;

public class InputUtility {
	private static Set<KeyCode> activeKeys = new HashSet<>();
	private static Queue<KeyCode> triggerKeys = new ConcurrentLinkedQueue<>();
	private static final Set<KeyCode> POLLABLE_KEYS = new HashSet<>();
	
	static {
		// KeyCode D -> key for chopping
		POLLABLE_KEYS.add(KeyCode.A);
		// for develop
		POLLABLE_KEYS.add(KeyCode.F);
		POLLABLE_KEYS.add(KeyCode.P);
	}
	
	public static boolean getKeyPressed(KeyCode keycode) {
		return activeKeys.contains(keycode);
	}
	
	public static void setKeyPressed(KeyCode keycode, boolean pressed) {
		if (pressed) {
			if (POLLABLE_KEYS.contains(keycode) && !activeKeys.contains(keycode)) {
				triggerKeys.add(keycode);
			}
			activeKeys.add(keycode);
		}else {
			activeKeys.remove(keycode);
		}
		System.out.println(activeKeys);
	}
	
	public static boolean isPollAvailable() {
		return triggerKeys.size() != 0;
	}
	
	public static KeyCode pollKey() {
		return triggerKeys.poll();
	}
}
