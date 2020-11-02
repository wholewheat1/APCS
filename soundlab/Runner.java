package soundlab;

import java.util.Scanner;

public class Runner {
	static SoundLabProbs lab = new SoundLabProbs();

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int[] poop = { 12, 4, 1, 5, 1, 36, 123, 5, 2, 4 };
		System.out.println(lab.minDifference(poop, 4));
		System.out.println(lab.reverseWords("Look at the sky!"));
		double[] clip;
		while (true) {
			int pog = scan.nextInt();

			switch (pog) {
			case 1:
				clip = Sound.pureTone(523.25, .5);
				Sound.show(clip);
				Sound.play(clip);
				break;
			case 2:
				clip = Sound.pureTone(554.37, .5);
				Sound.show(clip);
				Sound.play(clip);
				break;
			case 3:
				clip = Sound.pureTone(587.33, .5);
				Sound.show(clip);
				Sound.play(clip);
				break;
			}

		}

	}

}