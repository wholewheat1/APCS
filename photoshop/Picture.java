package photoshop;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

	/** The 2D array of pixels that comprise this picture */
	private Pixel[][] pixels;

	/**
	 * Creates a Picture from an image file in the "images" directory
	 * 
	 * @param picture The name of the file to load
	 */
	public Picture(String picture) {
		File file = new File("./images/" + picture);
		BufferedImage image;
		if (!file.exists())
			throw new RuntimeException("No picture at the location " + file.getPath() + "!");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		pixels = new Pixel[image.getHeight()][image.getWidth()];
		for (int y = 0; y < pixels.length; y++) {
			for (int x = 0; x < pixels[y].length; x++) {
				int rgb = image.getRGB(x, y);
				/*
				 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal
				 * integer The below extracts the individual values using bit-shifting and
				 * bit-wise ANDing with all 1's
				 */
				pixels[y][x] = new Pixel((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff);
			}
		}
	}

	/**
	 * Creates a solid-color Picture of a given color, width, and height
	 * 
	 * @param red    The red value of the color
	 * @param green  The green value of the color
	 * @param blue   The blue value of the color
	 * @param height The height of the Picture
	 * @param width  The width of the Picture
	 */
	public Picture(int red, int green, int blue, int height, int width) {
		pixels = new Pixel[height][width];
		for (int y = 0; y < pixels.length; y++) {
			for (int x = 0; x < pixels[y].length; x++) {
				pixels[y][x] = new Pixel(red, green, blue);
			}
		}
	}

	/**
	 * Creates a solid white Picture of a given width and height
	 * 
	 * @param color  The {@link Color} of the Picture
	 * @param height The height of the Picture
	 * @param width  The width of the Picture
	 */
	public Picture(int height, int width) {
		this(Color.WHITE, height, width);
	}

	/**
	 * Creates a solid-color Picture of a given color, width, and height
	 * 
	 * @param color  The {@link Color} of the Picture
	 * @param width  The width of the Picture
	 * @param height The height of the Picture
	 */
	public Picture(Color color, int height, int width) {
		this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
	}

	/**
	 * Creates a Picture based off of an existing {@link Pixel} 2D array
	 * 
	 * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
	 */
	public Picture(Pixel[][] pixels) {
		if (pixels.length == 0 || pixels[0].length == 0)
			throw new RuntimeException("Can't have an empty image!");
		int width = pixels[0].length;
		for (int i = 0; i < pixels.length; i++)
			if (pixels[i].length != width)
				throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels[" + i + "].length!");
		this.pixels = new Pixel[pixels.length][width];
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
			}
		}
	}

	/**
	 * Creates a Picture based off of an existing Picture
	 * 
	 * @param picture The Picture to copy
	 */
	public Picture(Picture picture) {
		this(picture.pixels);
	}

	/**
	 * Gets the width of the Picture
	 * 
	 * @return The width of the Picture
	 */
	public int getWidth() {
		return pixels[0].length;
	}

	/**
	 * Gets the height of the Picture
	 * 
	 * @return The height of the Picture
	 */
	public int getHeight() {
		return pixels.length;
	}

	/**
	 * Gets the {@link Pixel} at a given coordinate
	 * 
	 * @param x The x location of the {@link Pixel}
	 * @param y The y location of the {@link Pixel}
	 * @return The {@link Pixel} at the given location
	 */
	public Pixel getPixel(int x, int y) {
		if (x >= getWidth() || y >= getHeight() || x < 0 || y < 0)
			throw new RuntimeException("No pixel at (" + x + ", " + y + ")");
		return pixels[y][x];
	}

	/**
	 * Sets the {@link Pixel} at a given coordinate
	 * 
	 * @param x     The x location of the {@link Pixel}
	 * @param y     The y location of the {@link Pixel}
	 * @param pixel The new {@link Pixel}
	 */
	public void setPixel(int x, int y, Pixel pixel) {
		if (x >= getHeight() || y >= getWidth() || x < 0 || y < 0)
			throw new RuntimeException("No pixel at (" + x + ", " + y + ")");
		if (pixel == null)
			throw new NullPointerException("Pixel is null"); // guard is required because pixel's value isn't used in
																// this method
		pixels[y][x] = pixel;
	}

	/**
	 * Opens a {@link PictureViewer} to view this Picture
	 * 
	 * @return the {@link PictureViewer} viewing the Picture
	 */
	public PictureViewer view() {
		return new PictureViewer(this);
	}

	/**
	 * Return the 2D array of pixels that comprise this Picture You can save a
	 * reference to a Picture's pixels with the following: Pixel[][] pixels =
	 * pic.getPixels(); //for a Picture object called pic
	 * 
	 * @return 2D array of pixels that make up this Picture
	 */
	public Pixel[][] getPixels() {
		return pixels;
	}

	/**
	 * Save the image on disk as a JPEG Call programmatically on a Picture object,
	 * it will prompt you to choose a save location In the save dialogue window,
	 * specify the file AND extension (e.g. "lilies.jpg") Extension must be .jpg as
	 * ImageIO is expecting to write a jpeg
	 */
	public void save() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

		for (int r = 0; r < this.pixels.length; r++)
			for (int c = 0; c < this.pixels[0].length; c++)
				image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

		// user's Desktop will be default directory location
		JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

		chooser.setDialogTitle("Select picture save location / file name");

		File file = null;

		int choice = chooser.showSaveDialog(null);

		if (choice == JFileChooser.APPROVE_OPTION)
			file = chooser.getSelectedFile();

		// append extension if user didn't read save instructions
		if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg")
				&& !file.getName().endsWith(".JPEG"))
			file = new File(file.getAbsolutePath() + ".jpg");

		try {
			ImageIO.write(image, "jpg", file);
			System.out.println("File created at " + file.getAbsolutePath());
		} catch (IOException ex) {
			System.out.println("Can't write to location: " + file.toString());
		} catch (NullPointerException ex) {
			System.out.println("Invalid directory choice");
		} catch (IllegalArgumentException ex) {
			System.out.println("Dialog terminated before writing output");
		}
	}

	/********************************************************
	 *************** STUDENT METHODS BELOW ******************
	 ********************************************************/

	/** remove all blue tint from a picture */
	public void zeroBlue() {
		for (int i = 0; i < pixels.length; i++) {
			for (int x = 0; x < pixels[i].length; x++) {
				pixels[i][x].setBlue(0);

			}
		}
	}

	/** remove everything BUT blue tint from a picture */
	public void keepOnlyBlue() {
		for (int i = 0; i < pixels.length; i++) {
			for (int x = 0; x < pixels[i].length; x++) {
				pixels[i][x].setRed(0);
				pixels[i][x].setGreen(0);

			}
		}
	}

	/** invert a picture's colors */
	public void negate() {
		for (int i = 0; i < pixels.length; i++) {
			for (int x = 0; x < pixels[i].length; x++) {
				int r = pixels[i][x].getRed();
				int g = pixels[i][x].getGreen();
				int b = pixels[i][x].getBlue();
				pixels[i][x].setRed(255 - r);
				pixels[i][x].setGreen(255 - g);
				pixels[i][x].setBlue(255 - b);

			}
		}
	}

	/** simulate the over-exposure of a picture in film processing */
	public void solarize(int threshold) {
		for (int i = 0; i < pixels.length; i++) {
			for (int x = 0; x < pixels[i].length; x++) {
				int r = pixels[i][x].getRed();
				int g = pixels[i][x].getGreen();
				int b = pixels[i][x].getBlue();
				if (r > threshold) {
					pixels[i][x].setRed(255 - r);
				} else if (g > threshold) {
					pixels[i][x].setGreen(255 - g);
				} else if (b > threshold) {
					pixels[i][x].setBlue(255 - b);
				}

			}
		}
	}

	/** convert an image to grayscale */
	public void grayscale() {
		for (int i = 0; i < pixels.length; i++) {
			for (int x = 0; x < pixels[i].length; x++) {
				int r = pixels[i][x].getRed();
				int g = pixels[i][x].getGreen();
				int b = pixels[i][x].getBlue();
				int av = (r + g + b) / 3;
				pixels[i][x].setRed(av);
				pixels[i][x].setGreen(av);
				pixels[i][x].setBlue(av);

			}
		}
	}

	/** change the tint of the picture by the supplied coefficients */
	public void tint(double red, double blue, double green) {
		for (int i = 0; i < pixels.length; i++) {
			for (int x = 0; x < pixels[i].length; x++) {
				int r = (int) (pixels[i][x].getRed() * red);
				int g = (int) (pixels[i][x].getGreen() * green);
				int b = (int) (pixels[i][x].getBlue() * blue);
				System.out.println(r + ", " + g + ", " + b);
				pixels[i][x].setRed(r);
				pixels[i][x].setGreen(g);
				pixels[i][x].setBlue(b);

			}
		}
	}

	/** mirror an image about a vertical midline, left to right */
	public void mirrorVertical() {
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int r = 0; r < pixels.length; r++) {
			for (int c = 0; c < width / 2; c++) {
				leftPixel = pixels[r][c];
				rightPixel = pixels[r][(width - 1) - c];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** mirror about a vertical midline, right to left */
	public void mirrorRightToLeft() {
		// TODO
	}

	/** mirror about a horizontal midline, top to bottom */
	public void mirrorHorizontal() {
		// TODO
	}

	/** flip an image upside down about its bottom edge */
	public void verticalFlip() {
		// TODO
	}

	/** fix roof on greek temple */
	public void fixRoof() {
		// TODO
	}

	/** detect and mark edges in an image */
	public void edgeDetection(int dist) {
		// TODO
	}

	/**
	 * reduces the number of colors in an image to create a "graphic poster" effect
	 */
	public void posterize(int span) {
		for (int i = 0; i < pixels.length; i++) {
			for (int x = 0; x < pixels[i].length; x++) {
				int r = pixels[i][x].getRed();
				int g = pixels[i][x].getGreen();
				int b = pixels[i][x].getBlue();
				System.out.println(r + ", " + g + ", " + b);
				pixels[i][x].setRed(r);
				pixels[i][x].setGreen(g);
				pixels[i][x].setBlue(b);

			}
		}
	}

	/**
	 * copy another picture's pixels into this picture, if a color is within dist of
	 * param Color
	 */
	public void chromakey(Picture other, Color color, int dist) {
		// TODO
	}

	/** steganography encode (hide the message in msg in this picture) */
	public void encode(Picture msg) {
		// TODO
	}

	/**
	 * steganography decode (return a new Picture containing the message hidden in
	 * this picture)
	 */
	public Picture decode() {
		// TODO

		return null; // REPLACE
	}

	/** perform a simple blur using the colors of neighboring pixels */
	public Picture simpleBlur() {
		// TODO

		return null; // REPLACE
	}

	/** perform a blur using the colors of pixels within radius of current pixel */
	public Picture blur(int radius) {
		// TODO

		return null; // REPLACE
	}
}
