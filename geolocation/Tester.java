package geolocation;

import java.util.Scanner;

public class Tester {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Hello again, world!");
		// this is a comment!
		int numApples = 2;
		final int PRICE_OF_APPLES = 89;
		int totalPrice = numApples * PRICE_OF_APPLES;
		System.out.println("The total for " + numApples + " apples: " + (numApples * PRICE_OF_APPLES) + " cents");
		if (totalPrice > 2000) {
			System.out.println("Thank you valued customer!");
		}

		for (int n = 100; n >= 1; n--) {
			System.out.println(n);
		}

		for (int n = 150; n <= 300; n += 3) {
			System.out.println(n);
		}
		int i = 1, x = 0;
		System.out.println(x);
		for (int n = 1; n < 100; n++) {
			int f = n + x;
			System.out.println(i);

			x = i;

			i = f;
		}

		double num = scan.nextDouble();

		System.out.println(Math.sqrt(num));
		System.out.println(Math.pow(num, 3));

		int num1 = scan.nextInt(), num2 = scan.nextInt();

		if (num1 <= num2 + 10 && num1 >= num2 - 10) {
			System.out.println("Within 10");
		} else {
			System.out.println("Not within 10");
		}
		int what = scan.nextInt();
		int sum = 0;
		while (what != 0) {

			System.out.println(sum + what);
			sum += what;
			what = scan.nextInt();
		}
		double poop[] = { 4.56, 20, 00.1, 10, 20, 00.1, 10, 20, 00.1, 10, 20, 00.1, 10, 20, 00.1, 10, 20, 00.1, 10,
				10 };
		int length = poop.length;
		boolean pee[] = { true, true, false, false, true };

		triangle();
		altCaps("pepega PoweRRRRa");

	}

	public static void simpleMethod() {
		System.out.println("This is a method!");
	}

	public static int sum(int a, int b) {
		return a + b;

	}

	public static int sumToN(int n) {
		int a = 0, b = 0;
		for (int i = 0; i <= n; i += 3) {
			a = i;
		}
		for (int e = 0; e <= n; e += 5) {
			b = e;
		}
		return a + b;

	}

	public static void triangle() {
		int rows = 7, num = 1;
		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print(num);
			}
			++num;
			System.out.println();
		}
	}

	public static void altCaps(String s) {

		for (int i = 0, len = s.length(); i < len; i++) {
			char ch = s.charAt(i);
			if (i % 2 == 0) {
				System.out.print(Character.toLowerCase(ch));
			} else {
				System.out.print(Character.toUpperCase(ch));
			}
		}
		;

	}

}
