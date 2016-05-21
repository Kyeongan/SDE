package edu.uh.cs.sde;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		int n = sc.nextInt();
		if (n < 0 || n > 100) {
			System.out.println("Constraints: 1<N<100");
			return;
		}

		// 3 outputs : #, (), newline

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i + j > n)
					System.out.print("#");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
