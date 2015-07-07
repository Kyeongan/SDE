package edu.uh.cs.sde;

import java.util.Scanner;

public class ReverseString {

	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		String input = new String();


		while (true) {
			System.out.print("Type some words: ");
			input = scanner.nextLine();

			if ("quit".equals(input)) {
				System.out.print("Bye~");
				break;
			}

			System.out.println("-Input: " + input);
			System.out.println("\n-Reversed: " + r(input));
		}

	}

	public static String r(String s) {
		int len = s.length();
		int last = len - 1;
		char temp[] = s.toCharArray();

		for (int i = 0; i < (len / 2); i++) {
			char c = temp[i];
			temp[i] = temp[last];
			temp[last] = c;
			last--;
		}

		return new String(temp);
	}
}