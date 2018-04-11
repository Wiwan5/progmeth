package menuController;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import main.Main;

public class MenuControl {
	protected MenuTeb menu;
	protected Canvas menuCanvas;

	public MenuControl(Canvas mCanvas, MenuTeb menu) {
		this.menu = menu;
		this.menuCanvas = mCanvas;

	}

	public void keyEvent() {

		menuCanvas.setOnMouseMoved(e -> {
			if (e.getX() >= Main.width / 2 - 100 && e.getY() >= 450 && e.getX() <= 200 + Main.width / 2 - 100
					&& e.getY() <= 450 + 50) {
				System.out.println("Menu1");
				menu.setSelect(0);
			} else if (e.getX() >= Main.width / 2 - 100 && e.getY() >= 450 + 80
					&& e.getX() <= 200 + Main.width / 2 - 100 && e.getY() <= 450 + 50 + 80) {
				System.out.println("Menu2");
				menu.setSelect(1);
			} else if (e.getX() >= Main.width / 2 - 100 && e.getY() >= 450 + 80 + 80
					&& e.getX() <= 200 + Main.width / 2 - 100 && e.getY() <= 450 + 50 + 80 + 80) {
				System.out.println("Menu3");
				menu.setSelect(2);
			} else
				menu.setSelect(-1);
		});

		menuCanvas.setOnMousePressed(e -> {
			System.out.println("Click");
			if ((e.getX() >= Main.width / 2 - 100 && e.getY() >= 450 && e.getX() <= 200 + Main.width / 2 - 100
					&& e.getY() <= 450 + 50)
					|| (e.getX() >= Main.width / 2 - 100 && e.getY() >= 450 + 80
							&& e.getX() <= 200 + Main.width / 2 - 100 && e.getY() <= 450 + 50 + 80)
					|| (e.getX() >= Main.width / 2 - 100 && e.getY() >= 450 + 80 + 80
							&& e.getX() <= 200 + Main.width / 2 - 100 && e.getY() <= 450 + 50 + 80 + 80))
				menu.click();
		});
		/*
		 * menuC.setOnKeyPressed(e -> { if (e.getCode() == KeyCode.ENTER) {
		 * keyPress.add(KeyCode.ENTER); System.out.println("Menu1"); menu.setSelect(0);
		 * } }); menuC.setOnKeyReleased(e -> { if (keyPress.contains(KeyCode.ENTER)) {
		 * 
		 * menu.click(); } });
		 */
	}

}
