package Brickbreaker;

import java.awt.*;
public class Paddle extends Structure implements Constants {

	public Paddle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);

		/*doesn't work
		g.setColor(new Color(102, 178, 255));
		g.fillRect(x, y, 10, height);
		g.fillRect(x+60, y, 10, height);
		*/
	}
	public void reset() {
		x = PADDLE_X_START;
		y = PADDLE_Y_START;
	}

	//Checks if the ball hit the paddle
	public boolean hitPaddle(int ballX, int ballY) {
		if ((ballX >= x) && (ballX <= x + width) && ((ballY >= y) && (ballY <= y + height))) {
			return true;
		}
		return false;
	}

	public boolean caughtItem(Item i) {
		if ((i.getX() < x + width) && (i.getX() + i.getWidth() > x) && (y == i.getY() || y == i.getY() - 1)) {
			i.resizePaddle(this);
			return true;
		}
		return false;
	}
}
