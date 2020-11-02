package battingaverage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String txt = scan.nextLine();
		File file = new File(txt);
		String path = "C:\\Users\\158850\\eclipse-workspace\\APCS\\" + txt;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int p = scan.nextInt();
		scan.nextLine();

		// Team liberty = new Team(p);
		String content = "";
		for (int e = 0; e < p; e++) {
			String[] words = scan.nextLine().split(" ");

			System.out.println(words[3]);

		}

	}

}