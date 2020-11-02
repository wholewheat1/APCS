package circles;

import java.awt.Color;

public class Circle {
	double x, y, radius, dx, dy;
	Color color;

	Circle(double x, double y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}

	Circle(double x, double y, int radius, Color color, int dx, int dy) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		this.dx = dx;
		this.dy = dy;
	}

	void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, radius);
	}

	boolean overlaps(Circle other) {
		double distance = (Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2)));
		if (distance < radius + other.radius) {
			return true;
		}
		return false;
	}

	void update(int height, int width, Circle circle) {
		x += dx;
		y += dy;
		if (x >= width - circle.radius || x <= 0 + circle.radius || y >= height - circle.radius
				|| y <= 0 + circle.radius) {
			bounce();
		}
	}

	public void setDx(int x) {
		dx = x;
	}

	public void setDy(int y) {
		dy = y;
	}

	void bounce() {
		dx = -dx;
		dy = -dy;
	}
}
