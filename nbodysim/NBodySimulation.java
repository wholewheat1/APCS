package nbodysim;

public class NBodySimulation {
	private Body[] bodies; // stores all the bodies in the simulation
	private int numBodies = 300; // number of bodies in this simulation
	private double uRadius; // radius of the universe
	private String fileName; // file providing the input

	public NBodySimulation(String nameOfFile) {
		// TODO

		initCanvas(); // don't move, should be the last line of the constructor
	}

	/** initialize the drawing canvas */
	private void initCanvas() {
		StdDraw.setScale(750, 300); // set canvas size / scale
		StdDraw.picture(0, 0, "starfield.jpg"); // paint background

		// below is a for-each loop, which we will cover in the next lab
		// more info is available in the powerpoints, for the curious
		for (Body body : bodies)
			body.draw();
	}

	/**
	 * run the n-bodies simulation
	 * 
	 * @param T  total time to run the simulation, in seconds
	 * @param dt time step, in seconds
	 */
	public void run(double T, double dt) {
		// TODO
	}
}