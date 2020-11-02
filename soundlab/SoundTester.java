package soundlab;

public class SoundTester {
	public static void main(String[] args) {
//		adjustVolumeTest();
////		
//		mixTest();
////		
		appendTest();
//		
//		fadeInTest();
//		
//		fadeOutTest();
//		
//		reverseTest();
//		
//		speedUpTest();
	}

	public static void adjustVolumeTest() {
		SoundClip s = new SoundClip(Sound.pureTone(200, 1));

		Sound.show(s.clip);
		Sound.play(s.clip);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		s.adjustVolume(2);

		Sound.show(s.clip); // amplitude of wave should be 1/4 the original
		Sound.play(s.clip); // should play quieter than the original
	}

//	
//	/** this test will not be audible (sub-sonic frequencies used for better visuals) */
	public static void mixTest() {
		SoundClip s = new SoundClip(); // default constructor call!

		double[] clip1 = Sound.pureTone(100, 1);
		double[] clip2 = Sound.pureTone(200, 1);

		Sound.show(clip1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		Sound.show(clip2);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		double[] clip3 = s.mix(clip1, clip2);
		Sound.show(clip3);
		Sound.play(clip3);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * this test will not be audible (sub-sonic frequences used for better visuals)
	 */
	public static void appendTest() {
		SoundClip s = new SoundClip(Sound.pureTone(10, 1)); // 3Hz wave, 1s

		Sound.show(s.clip);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		s.append(Sound.pureTone(5, 2));

		Sound.show(s.clip); // the 2s long 5Hz clip should be appended to the 1s long 3Hz clip
	}

	public static void fadeInTest() {
		SoundClip s = new SoundClip(Sound.pureTone(200, 3));

		s.fadeIn(1);

		Sound.show(s.clip); // clip should fade in from 0 amplitude to full amplitude
		Sound.play(s.clip); // clip should gradually reach full volume over the course of first 1s
	}

//	
	public static void fadeOutTest() {
		SoundClip s = new SoundClip(Sound.pureTone(200, 3));

		s.fadeOut(1);

		Sound.show(s.clip); // clip should fade out to 0 amplitude from full amplitude
		Sound.play(s.clip); // cliip should gradually reach 0 amplitude at end over final 1s
	}

//	
	public static void reverseTest() {
		SoundClip s = new SoundClip(Sound.pureTone(400, 3));

		s.fadeIn(3);
		Sound.show(s.clip); // show faded in sound clip over entire 3s duration
		Sound.play(s.clip);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		s.reverse();

		Sound.show(s.clip); // should show the reverse of the previously shown clip
		Sound.play(s.clip);
	}
//	
//	public static void speedUpTest()
//	{
//		SoundClip s = new SoundClip(Sound.pureTone(300, 4)); //4s of a 300Hz wave
//		
//		Sound.show(s.clip);
//		Sound.play(s.clip);
//		try { Thread.sleep(4000); } catch (InterruptedException e) {}
//		
//		s.speedUp(4); //play 4x as fast, duration of clip should be 1s
//		
//		Sound.show(s.clip);
//		Sound.play(s.clip);
//		try { Thread.sleep(1000); } catch (InterruptedException e) {}
//	}
}