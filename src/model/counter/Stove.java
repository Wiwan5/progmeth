package model.counter;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.food.Chopable;
import model.food.IRenderableFood;
import model.food.Ingredient;
import model.food.Ripenable;

public class Stove extends Counter {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;
	static Image stove;
	static{
		stove = new Image("file:res/img/"+"counter"+6+".png");
	}
	public Stove(double x, double y, int w, int h) {
		super(x, y, w, h);
	}

	Runnable ripen = new Runnable() {
		@Override
		public void run() {
			Ripenable food = (Ripenable) foodOnCounter;
			long lastLoopStartTime = System.nanoTime();
			while (foodOnCounter != null && food.getTimeToRippened() < Ripenable.TIMEFORCOMPLETECHOPPED) {
				long elapsedTime = System.nanoTime() - lastLoopStartTime;
				if (elapsedTime >= LOOP_TIME) {
					lastLoopStartTime += LOOP_TIME;
					food.addTimeToRipened();
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (food.getTimeToRippened() >= Ripenable.TIMEFORCOMPLETECHOPPED) {
				food.setStateWhenCompleteRipen();
				System.out.println("Ingredient is complete ripened");
			}
		}
	};

	public void ripening() {
		Ingredient ingredient = (Ingredient) foodOnCounter;
		if (ingredient.getState() != model.food.Ingredient.CAN_RIPEN)
			return;
		new Thread(ripen).start();
	}

	@Override
	public IRenderableFood setFoodOnCounter(IRenderableFood food) {
		foodOnCounter = food;
		ripening();
		return null;
	}

	@Override
	public boolean canSettle(IRenderableFood foodOnPlayer) {
		if (foodOnCounter == null && foodOnPlayer instanceof Ripenable && foodOnPlayer instanceof Ingredient) {
			Ingredient ingredient = (Ingredient) foodOnPlayer;
			if (ingredient.getState() == model.food.Ingredient.CAN_RIPEN)
				return true;
		}
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(stove, x - width / 2, y - height, width, height);

		if (foodOnCounter != null) {
			foodOnCounter.draw(gc, x, y);
		}
	}

}