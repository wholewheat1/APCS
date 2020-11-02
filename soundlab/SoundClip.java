package soundlab;

public class SoundClip {
	double[] clip;

	SoundClip() {
		clip = null;
	}

	SoundClip(double[] bruh) {
		clip = bruh;
	}

	void adjustVolume(double factor) {
		for (int i = 0; i <= clip.length - 1; i++) {
			clip[i] = clip[i] * factor;
		}
	}

	double[] mix(double[] clip1, double[] clip2) {
		double length = clip1.length < clip2.length ? clip1.length : clip2.length;
		double[] result = new double[(int) length];
		for (int i = 0; i < length; i++) {
			result[i] = (clip1[i] + clip2[i]);
		}
		return result;
	}

	void append(double[] other) {
		System.arraycopy(other, 1, clip, 0, clip.length - 1);
	}

	void fadeIn(double seconds) {
		double samples = Sound.toNumSamples(seconds) - 1;
		for (int i = 0; i <= samples; i++) {
			double factor = i / samples;
			clip[i] = clip[i] * factor;

		}
	}

	void fadeOut(double seconds) {
		double samples = Sound.toNumSamples(seconds) - 1;
		for (int i = 0; i <= samples; i++) {
			double factor = i / samples;
			clip[i] = clip[i] * factor;

		}

		double[] dest_array = new double[clip.length];
		int j = clip.length;
		for (int i = 0; i < clip.length; i++) {
			dest_array[j - 1] = clip[i];
			j = j - 1;
		}

		clip = dest_array;
	}

	void reverse() {
		double[] dest_array = new double[clip.length];
		int j = clip.length;
		for (int i = 0; i < clip.length; i++) {
			dest_array[j - 1] = clip[i];
			j = j - 1;
		}

		clip = dest_array;
	}

	void speedUp(double factor) {

	}
}
