package photoshop;

import java.awt.Color;

public class PictureTester {
	public static void main(String[] args) {
		// construct a Picture object from a jpg image on disk
		Picture beach = new Picture("reddit.png");
		beach.tint(0.5, 1, 1);
		beach.view(); // calling the view() method displays the picture with the PictureViewer GUI

		// PUT YOUR TESTS HERE

	}

	/**
	 * this method is static, you don't need to call it on an object (just
	 * "testChromekey()")
	 */
	public static void testChromakey() {
		Picture one = new Picture("blue-mark.jpg");
		Picture two = new Picture("moon-surface.jpg");

		one.view(); // show original mustache guy picture
		two.view(); // show the untouched moon's surface pic

		one.chromakey(two, new Color(10, 40, 75), 60); // replace this color if within 60

		one.view();
	}

	/**
	 * this method is static, you don't need to call it on an object (just
	 * "testSteganography()")
	 */
	public static void testSteganography() {
		Picture msg = new Picture("msg.jpg");
		Picture beach = new Picture("beach.jpg");

		beach.encode(msg); // hide message in beach picture
		beach.view(); // beach w/ hidden message inside, shouldn't look different

		beach.decode().view(); // see the hidden message in the beach picture
	}
}
