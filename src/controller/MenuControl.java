package controller;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import view.MenuCanvas;

public class MenuControl {
	MenuTeb menu;
	MenuCanvas menuC;
	private Set<KeyCode> keyPress;
	
	public MenuControl(MenuCanvas mCanvas,MenuTeb menu) {
		this.menu = menu;
		this.menuC = mCanvas;
		keyPress = new ConcurrentSkipListSet<>();
	}
	
	public void keyEvent(){
		menuC.setOnKeyPressed(event -> {
			KeyCode code = event.getCode();
			if (!keyPress.contains(code)) {
				if (code == KeyCode.UP) {
					menu.changeselect(-1);
				}
				if (code == KeyCode.DOWN) {
					menu.changeselect(1);
				}
				if (code == KeyCode.ENTER) {
					menu.enter();
				}
				if(code == KeyCode.ESCAPE) {
					Platform.runLater(()->{
						Platform.exit();
						System.exit(0);
					});
				}
				keyPress.add(code);
			}
		});

		menuC.setOnKeyReleased(event -> {
			KeyCode code = event.getCode();
			keyPress.remove(code);
		});
	}
	
	public void reset() {
		keyPress.clear();
	}
	
}
