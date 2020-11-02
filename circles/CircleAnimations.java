package circles;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class CircleAnimations {
	private ArrayList<Circle> circles; // the circles to animate
	private int size; // canvas width and height (will be square)
	private Random rng; // use to make random numbers

	/** create a drawing pane of a particular size */
	public CircleAnimations(int s) {
		circles = new ArrayList<>();
		size = s;
		rng = new Random();

		// don't mess with this
		StdDraw.setCanvasSize(size, size); // set up drawing canvas
		StdDraw.setXscale(0, size); // <0, 0> is bottom left. <size-1, size-1> is top right
		StdDraw.setYscale(0, size);
	}

	void drawCircles() {

		for (int i = 0; i < circles.size(); i++) {

			circles.get(i).draw();
		}

	}

	void addCircles() {
		rng = new Random();
		for (int i = 0; i < 3; i++) {
			float r = rng.nextFloat();
			float g = rng.nextFloat();
			float b = rng.nextFloat();
			Color randomColor = new Color(r, g, b);
			circles.add(new Circle(rng.nextInt(size), rng.nextInt(size), rng.nextInt(40), randomColor));
		}
	}

	void addCircles(int num) {
		rng = new Random();
		for (int i = 0; i < num; i++) {
			float r = rng.nextFloat();
			float g = rng.nextFloat();
			float b = rng.nextFloat();
			Color randomColor = new Color(r, g, b);
			circles.add(new Circle(rng.nextInt(size), rng.nextInt(size), rng.nextInt(40), randomColor));
		}
	}

	void noOverlapping() {
		float r = rng.nextFloat();
		float g = rng.nextFloat();
		float b = rng.nextFloat();
		Color randomColor = new Color(r, g, b);
		circles.add(new Circle(rng.nextInt(size), rng.nextInt(size), rng.nextInt(40), randomColor));
		while (circles.size() < 2000) {

			r = rng.nextFloat();
			g = rng.nextFloat();
			b = rng.nextFloat();
			randomColor = new Color(r, g, b);
			Circle one = new Circle(rng.nextInt(size), rng.nextInt(size), rng.nextInt(40), randomColor);
			if (checkOverlaps(one)) {
				circles.add(one);
			}
		}
	}

	boolean checkOverlaps(Circle one) {
		boolean circleAdded = false;
		int e = 0;
		int j = 0;
		while (!circleAdded) {

			for (e = 0; e < circles.size(); e++) {

				if (!circles.get(e).overlaps(one)) {
					j++;

				} else {

				}
			}
			circleAdded = true;
		}
		if (j == circles.size()) {
			return true;
		} else {
			return false;
		}

	}

	void movingCircles() {
		addCircles();
		for (int i = 0; i < circles.size(); i++) {

			circles.get(i).setDx(rng.nextInt(5));
			circles.get(i).setDy(rng.nextInt(5));
		}
		while (true) {
			StdDraw.clear();

			circles.get(0).update(size, size, circles.get(0));
			circles.get(0).draw();

			StdDraw.pause(10);
		}

	}

	void removeClicked() {
		addCircles();
		float r = rng.nextFloat();
		float g = rng.nextFloat();
		float b = rng.nextFloat();
		Color randomColor = new Color(r, g, b);
		double mx = StdDraw.mouseX();
		double my = StdDraw.mouseY();
		while (true) {
			Circle one = new Circle(mx, my, 1, randomColor);

			if (StdDraw.isMousePressed()) {
				for (int i = 0; i < circles.size(); i++) {
					if (circles.get(i).overlaps(one)) {

						circles.remove(i);
					}
				}
			}
		}
	}
}